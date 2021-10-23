create table models(
    id bigserial not null primary key,
    title varchar(30) not null unique,
    group_title varchar(30),
    type varchar not null,
    color varchar,
    default_grams smallint,
    description varchar,

    constraint fk_title_group
        foreign key(group_title)
            references groups(title)
);
GO
