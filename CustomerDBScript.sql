create database `hibernatedb`;
use `hibernatedb`;

create table CUSTOMER(
id int primary key not null,
name varchar(30) ,
dob date
);

drop table customer;
