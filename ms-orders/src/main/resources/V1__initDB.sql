create table order_items
(
    id             bigserial primary key,
    title          varchar(255),
    quantity       int,
    price          int
);