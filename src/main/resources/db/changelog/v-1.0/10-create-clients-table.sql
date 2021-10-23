create table clients(
    id bigserial not null primary key,
    name varchar(30) not null unique ,
    contact varchar,
    description varchar
)
GO