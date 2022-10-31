create database `hibernatedb`;
use `hibernatedb`;

create table CUSTOMER(
id int primary key not null auto_increment,
name varchar(30) ,
dob date
);
insert into Customer values(
7000,'William','1995-05-17','Kolkata',
9067767872);

drop table customer;
