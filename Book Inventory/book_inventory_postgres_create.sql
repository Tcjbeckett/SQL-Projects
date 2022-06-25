
CREATE TABLE "author" (
	"author_id" serial NOT NULL,
	"first_name" VARCHAR(255) NOT NULL,
	"last_name" VARCHAR(255) NOT NULL,
	"book_id" integer NOT NULL,
	CONSTRAINT "author_pk" PRIMARY KEY ("author_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "order_book" (
	"order_id" serial NOT NULL,
	"book_id" integer NOT NULL,
	"books_sold" integer NOT NULL,
	"sale_price" DECIMAL NOT NULL,
	"date" TIMESTAMP NOT NULL,
	CONSTRAINT "order_book_pk" PRIMARY KEY ("order_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "sales" (
	"sales_id" serial NOT NULL,
	"order_id" integer NOT NULL,
	"customer_id" integer NOT NULL,
	"date" TIMESTAMP NOT NULL,
	"total_sale" DECIMAL NOT NULL,
	CONSTRAINT "sales_pk" PRIMARY KEY ("sales_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "inventory" (
	"book_id" integer NOT NULL,
	"starting_inv" integer NOT NULL DEFAULT '0',
	"books_acquired" integer NOT NULL,
	"books_sold" integer NOT NULL,
	"inventory_on_hand" integer NOT NULL,
	CONSTRAINT "inventory_pk" PRIMARY KEY ("book_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "acquisition" (
	"book_id" integer NOT NULL,
	"books_acquired" integer NOT NULL,
	"date" TIMESTAMP NOT NULL,
	"price_per_book" DECIMAL NOT NULL,
	"total_acquisition_price" DECIMAL NOT NULL,
	CONSTRAINT "acquisition_pk" PRIMARY KEY ("book_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "customer" (
	"customer_id" integer NOT NULL,
	"first_name" VARCHAR(255) NOT NULL,
	"last_name" VARCHAR(255) NOT NULL,
	CONSTRAINT "customer_pk" PRIMARY KEY ("customer_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "address" (
	"customer_id" integer,
	"address1" VARCHAR(255) NOT NULL,
	"address2" VARCHAR(255) NOT NULL,
	"city" VARCHAR(255) NOT NULL,
	"state" VARCHAR(255) NOT NULL,
	"zip" VARCHAR(255) NOT NULL,
	CONSTRAINT "address_pk" PRIMARY KEY ("customer_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "email" (
	"customer_id" integer NOT NULL,
	"email" VARCHAR(255) NOT NULL,
	CONSTRAINT "email_pk" PRIMARY KEY ("customer_id")
) WITH (
  OIDS=FALSE
);


