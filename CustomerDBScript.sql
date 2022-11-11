create database `hibernatedb`;
use `hibernatedb`;

create table  `hibernate_unique_key``(next_hi int);
insert into `hibernate_unique_key` value(1);

create table CUSTOMER(
id int primary key not null,
name varchar(30) ,
dob date
);

drop table customer;
