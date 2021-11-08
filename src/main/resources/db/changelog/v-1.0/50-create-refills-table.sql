create table refills(
    id bigserial not null primary key,
    refill_date date not null,
    cartridge_identify varchar(30),
    actual_grams smallint,
    changed_drum boolean,
    changed_pcr boolean,
    changed_magnet boolean,
    changed_rakel boolean,
    changed_doser_blade boolean,
    changed_chip boolean,
    changed_firmware boolean,
    comment varchar,
    employee_login varchar(30),
    is_issued_act boolean,

    constraint fk_cartridge_identify
       foreign key(cartridge_identify)
           references cartridges(unique_identify),

    constraint fk_employee_login
       foreign key(employee_login)
           references employees(login)
)
GO