create database StudentDB;
use StudentDB;
show databases ;

create table Student(
    Id int primary key auto_increment,
    Name varchar(50) not null,
    Age int not null,
    Marks double not null,
    Course varchar(50) not null,
    Address varchar(100) not null
);