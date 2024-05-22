alter table if exists transfer
    add column if not exists from_destination_name varchar(255);
alter table if exists transfer
    add column if not exists to_destination_name varchar(255);