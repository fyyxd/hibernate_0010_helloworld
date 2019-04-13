create table t_usres(
	id number(18) primary key,
	username varchar2(20) not null unique,
	password varchar2(20) not null,
	birth date default sysdate,
	sex number(1) default 1
);