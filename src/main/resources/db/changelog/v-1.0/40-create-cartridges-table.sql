create table cartridges(
    id bigserial not null primary key,
    added_date date not null,
    unique_identify varchar(30) not null,
    model_title bigint references models (title),
    client_naame bigint references clients (name),

    constraint fk_title_model
        foreign key(model_title)
            references models(title),

    constraint fk_name_client
        foreign key(client_name)
            references clients(name)
)
GO