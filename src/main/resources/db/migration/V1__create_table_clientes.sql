CREATE TABLE clientes
(
    id       BIGSERIAL PRIMARY KEY,
    nome     VARCHAR(255) NOT NULL,
    telefone VARCHAR(15)  NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL
);
