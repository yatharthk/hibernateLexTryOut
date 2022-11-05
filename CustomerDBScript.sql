create database `hibernatedb`;

use `hibernatedb`;

create table CUSTOMER(
id int primary key not null Auto_increment,
name varchar(30) ,
dob date,
address varchar(100),
phone_no long,
locker_id varchar(10) ,
foreign key (locker_id) references Locker(locker_id)
);

drop table customer;

insert into Customer values(
7000,'William','1995-05-17','Kolkata',
9067767872,'LOC101');

drop table customer;
