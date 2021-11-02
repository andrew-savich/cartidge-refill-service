create table employees(
    id bigserial not null primary key,
    login varchar(30) not null unique,
    password varchar(30) not null,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    position varchar(30) not null
)
GO