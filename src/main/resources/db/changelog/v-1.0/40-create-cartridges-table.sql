create table cartridges(
    id bigserial not null primary key,
    added_date date not null,
    unique_identify varchar(30) not null,
    model_id bigint references models (id),
    client_id bigint references clients (id)
)
GO