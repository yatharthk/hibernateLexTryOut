create database `hibernatedb`;

use `hibernatedb`;

create table Locker(
locker_id varchar(10) primary key not null,
locker_type varchar(30) ,
rent int
);

insert INTO lOCKER VALUES('LOC101','Small',1100);
