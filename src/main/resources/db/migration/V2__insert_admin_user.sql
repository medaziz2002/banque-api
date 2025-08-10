
-- Insert roles
insert into role (id, name) values (nextval('role_seq'), 'ROLE_USER');
insert into role (id, name) values (nextval('role_seq'), 'ROLE_ADMIN');

-- Insert admin user with pre-hashed password
-- Note: Using pre-hashed password instead of pgcrypto for H2 compatibility
insert into "user" (id, active, email, firstname, lastname, password)
values (nextval('user_seq'), true, 'admin@aziz.com', 'Aziz', 'Belhaj Hssine',
        '$2a$10$3ek/PrpenD0.ppuO7Jp7HulcpTqpcUrETeKbIVwUrU139n5Co3nZO');

-- Assign admin role to user
insert into user_roles (users_id, roles_id)
values (
           (select id from "user" where email = 'admin@aziz.com'),
           (select id from role where name = 'ROLE_ADMIN')
       );