use Arshad;
create table if not exists student(
    id int primary key auto_increment,
    name varchar(50) not null,
    age int not null,
    grade varchar(10) not null
);
insert into student(name, age, grade) values('Alice', 20, 'A');
insert into student(name, age, grade) values('Bob', 22, 'B');
insert into student(name, age, grade) values('Charlie', 19, 'A');
insert into student(name, age, grade) values('David', 21, 'C');
insert into student(name, age, grade) values('Eve', 20, 'B');

show tables;
select * from student;