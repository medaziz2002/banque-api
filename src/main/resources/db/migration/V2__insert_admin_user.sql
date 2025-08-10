insert into role (id, name)
values (nextval('role_seq'), 'ROLE_USER');

insert into role (id, name)
values (nextval('role_seq'), 'ROLE_ADMIN');

CREATE EXTENSION IF NOT EXISTS pgcrypto;

insert into _user (id, active, email, firstname, lastname, password)
values (nextval('_user_seq'), true, 'admin@aziz.com', 'Aziz', 'Belhaj Hssine', '$2a$10$3ek/PrpenD0.ppuO7Jp7HulcpTqpcUrETeKbIVwUrU139n5Co3nZO');


insert into _user_roles (users_id, roles_id)
values ((select id from _user where email = 'admin@aziz.com'), (select id from role where name = 'ROLE_ADMIN'));
