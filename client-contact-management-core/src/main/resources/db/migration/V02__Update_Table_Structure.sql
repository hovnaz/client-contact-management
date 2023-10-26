-- Update the 'client' table
ALTER TABLE client RENAME COLUMN clientName TO client_name;
ALTER TABLE client RENAME COLUMN createAt TO create_at;
ALTER TABLE client RENAME COLUMN updateAt TO update_at;
ALTER TABLE client RENAME COLUMN deletedFlag TO deleted_flag;

-- Update the 'client_contact_email' table
ALTER TABLE client_contact_email RENAME COLUMN createAt TO create_at;
ALTER TABLE client_contact_email RENAME COLUMN updateAt TO update_at;
ALTER TABLE client_contact_email RENAME COLUMN deletedFlag TO deleted_flag;

-- Update the 'client_contact_phone_number' table
ALTER TABLE client_contact_phone_number RENAME COLUMN phoneNumber TO phone_number;
ALTER TABLE client_contact_phone_number RENAME COLUMN createAt TO create_at;
ALTER TABLE client_contact_phone_number RENAME COLUMN updateAt TO update_at;
ALTER TABLE client_contact_phone_number RENAME COLUMN deletedFlag TO deleted_flag;
