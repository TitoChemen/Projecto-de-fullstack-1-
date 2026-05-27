CREATE TABLE inventario (
    id bigint auto_increment primary key,
    stock_disponible int not null,
    pasillo_bodega varchar(50),
    estado_stock varchar(50),
    id_carrito bigint
);