use cinema_schedule;
create table customer( 
user_name varchar(20),
first_name varchar(20),
last_name varchar(20),
mobile int, 
dob date,
gender char(10),
email varchar(30),
password varchar(20),
primary key (user_name)
);

create table cinema(
key_name varchar(20),
c_name varchar(20),
c_mobile varchar(20),
c_adress varchar(20),
c_email varchar(20),
c_password varchar(20),
primary key (key_name)
);

create table film(
film_id varchar(20),
f_date date,
f_type varchar(20),
f_time varchar(20),
f_price int,
f_description varchar(500),
photo longblob,
key_name varchar(20),
primary key(film_id),
foreign key (key_name) references cinema(key_name)
);

create table cinemauser(
user_name varchar(20),
key_name varchar(20),
primary key(user_name,key_name),
foreign key (key_name) references cinema(key_name),
foreign key (user_name) references customer(user_name)

);

create table userfilm(
user_name varchar(20),
film_id varchar(20),
key_name varchar(20),
primary key(user_name,film_id,key_name),
foreign key(key_name) references cinema(Key_name),
foreign key (user_name) references customer(user_name),
foreign key (film_id) references film(film_id)
);