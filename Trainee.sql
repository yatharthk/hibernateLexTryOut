use hibernatedb;
create table trainee(
trainee_id int primary key not null auto_increment,
trainee_name varchar(30),
trainee_asset varchar(20), 
foreign key (trainee_asset) references desktop(assetId)
);

alter table trainee auto_increment=100;

drop table trainee;