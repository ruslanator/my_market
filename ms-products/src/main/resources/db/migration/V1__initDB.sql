create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into products (title, price)
values ('Fish', 400),
       ('Cheese', 240),
       ('Potato', 20),
       ('Milk', 34),
       ('Meat', 99),
       ('Orange', 120),
       ('Tomato', 111),
       ('Tee', 30),
       ('Coffee', 120);