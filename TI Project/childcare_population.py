#!/usr/bin/env python
# coding: utf-8

# In[158]:


import boto3
import pandas as pd
from io import StringIO


# In[159]:


AWS_ACCESS_KEY = ""
AWS_SECRET_KEY = ""
AWS_REGION = "us-east-1"
SCHEMA_NAME = "childcare_population_dataset"
S3_STAGING_DIR = "s3://athena-output-childcare-population-dataset/output/"
S3_BUCKET_NAME = "athena-output-childcare-population-dataset"
S3_OUTPUT_DIRECTORY = "output"


# In[160]:


athena_client = boto3.client(
'athena',
aws_access_key_id=AWS_ACCESS_KEY,
aws_secret_access_key=AWS_SECRET_KEY,
region_name=AWS_REGION,
)


# In[161]:


Dict = {}
def download_and_load_query_results(
client: boto3.client, query_response: Dict
) -> pd.DataFrame:
    while True:
        try:
            client.get_query_results(
                QueryExecutionId=query_response['QueryExecutionId']
            )
            break
        except Exception as err:
            if "not yet finished" in str(err):
                time.sleep(0.001)
            else:
                raise err
    temp_file_location: str ="childcare_population_results.csv"
    s3_client = boto3.client(
    "s3",
    aws_access_key_id=AWS_ACCESS_KEY,
    aws_secret_access_key=AWS_SECRET_KEY,
    region_name=AWS_REGION,
    )
    s3_client.download_file(
        S3_BUCKET_NAME,
        f"{S3_OUTPUT_DIRECTORY}/{query_response['QueryExecutionId']}.csv",
        temp_file_location,
    )
    return pd.read_csv(temp_file_location)


# In[162]:


response = athena_client.start_query_execution(
    QueryString="SELECT * FROM de_childcare_providers",
    QueryExecutionContext={
        "Database": SCHEMA_NAME
        },
    ResultConfiguration={
        'OutputLocation': S3_STAGING_DIR,
        "EncryptionConfiguration":{"EncryptionOption": "SSE_S3"},
    },
)   


# In[163]:


response


# In[164]:


de_childcare_providers = download_and_load_query_results(athena_client, response)


# In[165]:


de_childcare_providers.head()


# In[166]:


response = athena_client.start_query_execution(
    QueryString="SELECT * FROM population_stats_for_de_2015_2016_5y___under_5",
    QueryExecutionContext={
        "Database": SCHEMA_NAME
        },
    ResultConfiguration={
        'OutputLocation': S3_STAGING_DIR,
        "EncryptionConfiguration":{"EncryptionOption": "SSE_S3"},
    },
)   


# In[167]:


population_stats_for_de_2015_2016_5y___under_5 = download_and_load_query_results(athena_client, response)


# In[168]:


population_stats_for_de_2015_2016_5y___under_5.head()


# In[169]:


combined_data_1 = de_childcare_providers[['license_number', 'county', 'type_of_child_care', 'city', 'age_range', 'capacity', 'count']]
combined_data_2 = population_stats_for_de_2015_2016_5y___under_5[['county', 'total_pop', 'total_pop_under_5']]
combined_data = pd.merge(combined_data_1, combined_data_2, how='outer' )


# In[170]:


combined_data.head()


# In[171]:


bucket = 'athena-output-childcare-population-dataset'


# In[172]:


csv_buffer = StringIO()


# In[173]:


combined_data.to_csv(csv_buffer)


# In[174]:


s3_resource = boto3.resource(
    's3',
    aws_access_key_id=AWS_ACCESS_KEY,
    aws_secret_access_key=AWS_SECRET_KEY,
    region_name=AWS_REGION,
)


# In[175]:


s3_resource.Object(bucket, 'output/combined_data.csv').put(Body=csv_buffer.getvalue())


# In[176]:


bucket = 'athena-output-childcare-population-dataset'
csv_buffer = StringIO()
combined_data_1.to_csv(csv_buffer)
s3_resource = boto3.resource(
    's3',
    aws_access_key_id=AWS_ACCESS_KEY,
    aws_secret_access_key=AWS_SECRET_KEY,
    region_name=AWS_REGION,
)
s3_resource.Object(bucket, 'output/combined_data_1.csv').put(Body=csv_buffer.getvalue())


# In[177]:


bucket = 'athena-output-childcare-population-dataset'
csv_buffer = StringIO()
combined_data_2.to_csv(csv_buffer)
s3_resource = boto3.resource(
    's3',
    aws_access_key_id=AWS_ACCESS_KEY,
    aws_secret_access_key=AWS_SECRET_KEY,
    region_name=AWS_REGION,
)
s3_resource.Object(bucket, 'output/combined_data_2.csv').put(Body=csv_buffer.getvalue())


# In[178]:


combined_data_1sql = pd.io.sql.get_schema(combined_data_1.reset_index(), 'combined_data_1')
print(''.join(combined_data_1sql))


# In[179]:


combined_data_2sql = pd.io.sql.get_schema(combined_data_2.reset_index(), 'combined_data_2')
print(''.join(combined_data_2sql))


# In[180]:


combined_datasql = pd.io.sql.get_schema(combined_data.reset_index(), 'combined_data')
print(''.join(combined_datasql))


# In[181]:


import redshift_connector


# In[185]:


conn = redshift_connector.connect(
host='redshift-cluster-1.cipnettqiss0.us-east-1.redshift.amazonaws.com',
database='dev',
user='awsuser',
password='Password123!'
 )
           
                 


# In[186]:


conn.autocommit = True


# In[192]:


cursor = redshift_connector.Cursor = conn.cursor()
cursor.execute("""
               CREATE TABLE "combined_data_1" (
"index" INTEGER,
  "license_number" INTEGER,
  "county" TEXT,
  "type_of_child_care" TEXT,
  "city" TEXT,
  "age_range" TEXT,
  "capacity" INTEGER,
  "count" INTEGER
)
""")


# In[193]:



cursor.execute("""
               CREATE TABLE "combined_data_2" (
"index" INTEGER,
  "county" TEXT,
  "total_pop" INTEGER,
  "total_pop_under_5" INTEGER
)
""")


# In[194]:


cursor.execute("""
               CREATE TABLE "combined_data" (
"index" INTEGER,
  "license_number" REAL,
  "county" TEXT,
  "type_of_child_care" TEXT,
  "city" TEXT,
  "age_range" TEXT,
  "capacity" REAL,
  "count" REAL,
  "total_pop" REAL,
  "total_pop_under_5" REAL
)
""")


# In[201]:


cursor.execute("""
copy combined_data_1 from 's3://athena-output-childcare-population-dataset/output/combined_data_1.csv'
credentials 'aws_iam_role=arn:aws:iam::298203450806:role/redshift-s3-access'
delimiter ','
region 'us-east-1'
IGNOREHEADER 1
""")


# In[202]:


cursor.execute("""
copy combined_data_2 from 's3://athena-output-childcare-population-dataset/output/combined_data_2.csv'
credentials 'aws_iam_role=arn:aws:iam::298203450806:role/redshift-s3-access'
delimiter ','
region 'us-east-1'
IGNOREHEADER 1
""")


# In[ ]:




