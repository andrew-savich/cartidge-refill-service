alter table refills
    DROP CONSTRAINT fk_cartridge_identify,
    DROP CONSTRAINT fk_employee_login;
GO

drop table refills;
GO