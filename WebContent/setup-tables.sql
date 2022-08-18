create database reserve;
create table facility
(
   id int primary key auto_increment,
   name varchar (30) not null
);
create table master
(
   id int primary key auto_increment,
   rdate date  not null,
   r08 varchar(10),
   r09 varchar(10),
   r10 varchar(10),
   r11 varchar(10),
   r12 varchar(10),
   r13 varchar(10),
   r14 varchar(10),
   r15 varchar(10),
   r16 varchar(10),
   r17 varchar(10)
);
