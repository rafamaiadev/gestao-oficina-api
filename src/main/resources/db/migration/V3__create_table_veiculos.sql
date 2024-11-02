CREATE TABLE veiculos
(
    id             SERIAL PRIMARY KEY,
    placa          VARCHAR(255) NOT NULL,
    modelo         VARCHAR(255) NOT NULL,
    ano_fabricacao INT          NOT NULL,
    tipo           VARCHAR(255) NOT NULL,
    cliente_id     BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES clientes (id) ON DELETE CASCADE
);