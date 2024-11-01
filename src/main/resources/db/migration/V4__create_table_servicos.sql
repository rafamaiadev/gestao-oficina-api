CREATE TABLE servicos
(
    id            BIGSERIAL PRIMARY KEY,
    descricao     VARCHAR(255)   NOT NULL,
    preco_base    DECIMAL(10, 2) NOT NULL,
    duracao_media INTEGER        NOT NULL
);
