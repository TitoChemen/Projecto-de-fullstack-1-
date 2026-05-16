CREATE TABLE descuento (
    id bigint auto_increment primary key,
    monto_original   bigint not null,
    monto_descuento  bigint not null
);