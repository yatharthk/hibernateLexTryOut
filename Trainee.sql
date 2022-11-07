use hibernatedb;
create table trainee(
trainee_id int primary key not null auto_increment,
trainee_name varchar(30),
asset_id varchar(20), 
foreign key (asset_id) references Desktops(asset_id)
);

alter table trainee auto_increment=100;

drop table trainee;