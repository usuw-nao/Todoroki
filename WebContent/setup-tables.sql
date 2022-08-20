create database reserve;
create table facility
(
   id int primary key auto_increment,
   name varchar (30) not null
);
create table master
(
   id int primary key auto_increment,
   name varchar(30) not null,
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
insert into master values(
1,"小学３年生〜５年生対象サッカー教室",20220901,"空き","満員","空き","空き","空き","空き","空き","空き","空き","空き");

insert into master values(
2,"小学1年生〜3年生対象サッカー教室",20220902,"空き","空き","空き","空き","空き","空き","空き","空き","空き","空き");

