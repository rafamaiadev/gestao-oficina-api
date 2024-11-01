CREATE TABLE funcionarios
(
    id       BIGSERIAL PRIMARY KEY,
    nome     VARCHAR(255) NOT NULL,
    funcao   VARCHAR(255) NOT NULL,
    telefone VARCHAR(15)  NOT NULL,
    email    VARCHAR(255) NOT NULL
);
