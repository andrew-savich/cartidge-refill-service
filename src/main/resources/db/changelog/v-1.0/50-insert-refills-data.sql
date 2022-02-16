INSERT INTO refills
(refill_date, cartridge_id, actual_grams, changed_drum, changed_pcr, changed_magnet, changed_rakel, changed_doser_blade, changed_chip, changed_firmware, is_issued_act, employee_id)
VALUES
    ('2021-10-24', 1, 90, true, false, true, false, true, false, true, false, 1),
    ('2021-10-24', 2, 90, false, true, false, true, false, true, false, true, 1),
    ('2021-10-24', 3, 90, true, false, true, false, true, false, true, false, 1),
    ('2021-10-24', 4, 90, false, true, false, true, false, true, false, true, 1),
    ('2021-10-24', 5, 90, true, false, true, false, true, false, true, false, 1),
    ('2021-10-24', 1, 90, false, true, false, true, false, true, false, true, 1);
GO
