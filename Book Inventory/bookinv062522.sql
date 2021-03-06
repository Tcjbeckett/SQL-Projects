PGDMP                         z           BookInventory    14.4    14.4 !               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    18279    BookInventory    DATABASE     s   CREATE DATABASE "BookInventory" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "BookInventory";
                postgres    false            ?            1259    18868    acquisition    TABLE     ?   CREATE TABLE public.acquisition (
    book_id integer NOT NULL,
    books_acquired integer NOT NULL,
    date timestamp without time zone NOT NULL,
    price_per_book numeric NOT NULL,
    total_acquisition_price numeric NOT NULL
);
    DROP TABLE public.acquisition;
       public         heap    postgres    false            ?            1259    18836    author    TABLE     ?   CREATE TABLE public.author (
    author_id integer NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    book_id integer
);
    DROP TABLE public.author;
       public         heap    postgres    false            ?            1259    18835    author_author_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.author_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.author_author_id_seq;
       public          postgres    false    212                       0    0    author_author_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.author_author_id_seq OWNED BY public.author.author_id;
          public          postgres    false    211            ?            1259    18756    book    TABLE     ?   CREATE TABLE public.book (
    book_id integer NOT NULL,
    title character varying(255) NOT NULL,
    author_id integer NOT NULL,
    isbn integer NOT NULL,
    sale_price numeric NOT NULL
);
    DROP TABLE public.book;
       public         heap    postgres    false            ?            1259    18755    book_book_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.book_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.book_book_id_seq;
       public          postgres    false    210                       0    0    book_book_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.book_book_id_seq OWNED BY public.book.book_id;
          public          postgres    false    209            ?            1259    18862 	   inventory    TABLE     ?   CREATE TABLE public.inventory (
    book_id integer NOT NULL,
    books_acquired integer,
    books_sold integer,
    inventory_on_hand integer
);
    DROP TABLE public.inventory;
       public         heap    postgres    false            j           2604    19016    author author_id    DEFAULT     t   ALTER TABLE ONLY public.author ALTER COLUMN author_id SET DEFAULT nextval('public.author_author_id_seq'::regclass);
 ?   ALTER TABLE public.author ALTER COLUMN author_id DROP DEFAULT;
       public          postgres    false    211    212    212            i           2604    19017    book book_id    DEFAULT     l   ALTER TABLE ONLY public.book ALTER COLUMN book_id SET DEFAULT nextval('public.book_book_id_seq'::regclass);
 ;   ALTER TABLE public.book ALTER COLUMN book_id DROP DEFAULT;
       public          postgres    false    209    210    210                      0    18868    acquisition 
   TABLE DATA           m   COPY public.acquisition (book_id, books_acquired, date, price_per_book, total_acquisition_price) FROM stdin;
    public          postgres    false    214   ?%                 0    18836    author 
   TABLE DATA           K   COPY public.author (author_id, first_name, last_name, book_id) FROM stdin;
    public          postgres    false    212   ?%                 0    18756    book 
   TABLE DATA           K   COPY public.book (book_id, title, author_id, isbn, sale_price) FROM stdin;
    public          postgres    false    210   	&                 0    18862 	   inventory 
   TABLE DATA           [   COPY public.inventory (book_id, books_acquired, books_sold, inventory_on_hand) FROM stdin;
    public          postgres    false    213   |&                  0    0    author_author_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.author_author_id_seq', 6, true);
          public          postgres    false    211                       0    0    book_book_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.book_book_id_seq', 7, true);
          public          postgres    false    209            x           2606    18995    acquisition acquisition_fk1 
   CONSTRAINT     `   ALTER TABLE ONLY public.acquisition
    ADD CONSTRAINT acquisition_fk1 UNIQUE (books_acquired);
 E   ALTER TABLE ONLY public.acquisition DROP CONSTRAINT acquisition_fk1;
       public            postgres    false    214            z           2606    18874    acquisition acquisition_pk 
   CONSTRAINT     ]   ALTER TABLE ONLY public.acquisition
    ADD CONSTRAINT acquisition_pk PRIMARY KEY (book_id);
 D   ALTER TABLE ONLY public.acquisition DROP CONSTRAINT acquisition_pk;
       public            postgres    false    214            p           2606    18843    author author_pk 
   CONSTRAINT     U   ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pk PRIMARY KEY (author_id);
 :   ALTER TABLE ONLY public.author DROP CONSTRAINT author_pk;
       public            postgres    false    212            l           2606    18765    book book_isbn_key 
   CONSTRAINT     M   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_isbn_key UNIQUE (isbn);
 <   ALTER TABLE ONLY public.book DROP CONSTRAINT book_isbn_key;
       public            postgres    false    210            n           2606    18763    book book_pk 
   CONSTRAINT     O   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pk PRIMARY KEY (book_id);
 6   ALTER TABLE ONLY public.book DROP CONSTRAINT book_pk;
       public            postgres    false    210            r           2606    18984    inventory inventory_fk1 
   CONSTRAINT     X   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_fk1 UNIQUE (books_sold);
 A   ALTER TABLE ONLY public.inventory DROP CONSTRAINT inventory_fk1;
       public            postgres    false    213            t           2606    18997    inventory inventory_fk2 
   CONSTRAINT     \   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_fk2 UNIQUE (books_acquired);
 A   ALTER TABLE ONLY public.inventory DROP CONSTRAINT inventory_fk2;
       public            postgres    false    213            v           2606    18867    inventory inventory_pk 
   CONSTRAINT     Y   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_pk PRIMARY KEY (book_id);
 @   ALTER TABLE ONLY public.inventory DROP CONSTRAINT inventory_pk;
       public            postgres    false    213            ~           2606    18966    acquisition acquisition_fk0    FK CONSTRAINT     ~   ALTER TABLE ONLY public.acquisition
    ADD CONSTRAINT acquisition_fk0 FOREIGN KEY (book_id) REFERENCES public.book(book_id);
 E   ALTER TABLE ONLY public.acquisition DROP CONSTRAINT acquisition_fk0;
       public          postgres    false    3182    210    214            |           2606    18941    author author_fk    FK CONSTRAINT     s   ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_fk FOREIGN KEY (book_id) REFERENCES public.book(book_id);
 :   ALTER TABLE ONLY public.author DROP CONSTRAINT author_fk;
       public          postgres    false    212    210    3182            {           2606    18936    book book_fk    FK CONSTRAINT     u   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_fk FOREIGN KEY (author_id) REFERENCES public.author(author_id);
 6   ALTER TABLE ONLY public.book DROP CONSTRAINT book_fk;
       public          postgres    false    210    3184    212            }           2606    19011    inventory book_id    FK CONSTRAINT     ~   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT book_id FOREIGN KEY (book_id) REFERENCES public.book(book_id) NOT VALID;
 ;   ALTER TABLE ONLY public.inventory DROP CONSTRAINT book_id;
       public          postgres    false    213    3182    210                       2606    18998    acquisition books_acquired    FK CONSTRAINT     ?   ALTER TABLE ONLY public.acquisition
    ADD CONSTRAINT books_acquired FOREIGN KEY (books_acquired) REFERENCES public.inventory(books_acquired) NOT VALID;
 D   ALTER TABLE ONLY public.acquisition DROP CONSTRAINT books_acquired;
       public          postgres    false    214    3188    213                  x?????? ? ?         I   x?3?N,J??I-.?4?2?t?O???/H????2???L?HL????/JI???q:??T?%V?b???? ˝?         c   x?ɱ? ???L@9????ll4??D?????>??sA?VZ&?????I??A??=?zn͗/??? U??S??t?7???0?[???"???F?            x?????? ? ?     