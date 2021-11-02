create table groups(
    id bigserial not null primary key,
    title varchar(30) not null unique,
    description varchar
)
GO