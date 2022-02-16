create table refills(
    id bigserial not null primary key,
    refill_date date not null,
    cartridge_id bigint,
    actual_grams smallint,
    changed_drum boolean,
    changed_pcr boolean,
    changed_magnet boolean,
    changed_rakel boolean,
    changed_doser_blade boolean,
    changed_chip boolean,
    changed_firmware boolean,
    comment varchar,
    employee_id bigint,
    is_issued_act boolean,

    constraint fk_cartridge_id
       foreign key(cartridge_id)
           references cartridges(id),

    constraint fk_employee_id
       foreign key(employee_id)
           references employees(id)
)
GO