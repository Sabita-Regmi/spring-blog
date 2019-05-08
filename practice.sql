CREATE TABLE users(
id long not null auto_increament,
firstName varchar(200) not null,
lastName varchar(200) not null,
address varchar(300) not null,
zip_code int not null,
primary key (id)
)