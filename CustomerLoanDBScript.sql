create database `hibernatedb`;
use `hibernatedb`;

create table CUSTOMER_LOAN(
customer_id int not null,
loan_id varchar(10) not null,
eligible_amount int,
availed_amount int,
tenure_in_years int
);
insert into Customer_Loan values(5001,101,2500000,1500000,20);
insert into Customer_Loan values(5001,102,300000,100000,5);

drop table customer;
