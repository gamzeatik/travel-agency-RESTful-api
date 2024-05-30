alter table if exists reservation
    drop column if exists transfer_id;

alter table if exists reservation
    add column if not exists first_transfer_id uuid;

alter table if exists reservation
    add column if not exists second_transfer_id uuid;