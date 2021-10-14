create table models(
    id bigserial not null primary key,
    title varchar(30) not null,
    group_id bigint references groups (id),
    type varchar not null,
    color varchar,
    description varchar
)
GO