create table Person(
id int PRIMARY KEY,
name varchar(100),
age int
);

INSERT INTO Person (id, name, age) VALUES (1,'Test person', 20);

select * from Person;