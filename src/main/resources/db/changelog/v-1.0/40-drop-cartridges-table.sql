alter table cartridge
    DROP CONSTRAINT fk_title_model;
GO

alter table cartridge
    DROP CONSTRAINT fk_name_client;
GO

drop table cartridges;
GO