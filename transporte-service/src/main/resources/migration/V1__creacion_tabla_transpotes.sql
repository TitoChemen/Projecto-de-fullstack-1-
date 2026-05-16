CREATE TABLE transporte (
    id bigint auto_increment primary key,
    nro_boleta varchar(100),
    empresa_transporte varchar(100),
    rut_destinatario varchar(15),
    direc_destino varchar(255),
    fecha_entrega_aprox date
);