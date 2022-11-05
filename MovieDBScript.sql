use `hibernatedb`;

create table MOVIE(
id varchar(30) primary key not null,
name varchar(30) ,
language varchar(30) ,
released_in int,
revenue_in_dollars int
);

Insert into Movie values('1001','Home Alone','English',1990	,4767000);
Insert into Movie values('1002','Paa','Hindi',2009,4700000);

drop table movie;
