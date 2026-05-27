-- Primero creamos la tabla categoria, ya que producto depende de ella
CREATE TABLE categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL);

-- Luego creamos la tabla productos
CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    precio DOUBLE,
    stock INT,
    categoria_id BIGINT,
    CONSTRAINT uk_productos_codigo UNIQUE (codigo),
    CONSTRAINT fk_productos_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id));