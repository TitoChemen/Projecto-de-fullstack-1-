-- V2__datos_de_prueba.sql

-- Insertar categorías iniciales
INSERT INTO categoria (nombre) VALUES
    ('Gamer'),
    ('Audio y Accesorios'),
    ('Componentes');

-- Insertar productos de prueba
INSERT INTO productos (codigo, nombre, precio, stock, categoria_id) VALUES
    ('AUD-001', 'Audífonos Over-Ear Blik Soul 900', 35000.0, 10, 2),
    ('TEC-001', 'Teclado Mecánico RGB', 45000.0, 15, 1),
    ('MON-001', 'Monitor 144Hz 24 pulgadas', 150000.0, 5, 1);