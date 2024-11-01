CREATE TABLE ordens_servico
(
    id             BIGSERIAL PRIMARY KEY,
    descricao      VARCHAR(255) NOT NULL,
    data_abertura  DATE         NOT NULL,
    status         VARCHAR(50)  NOT NULL,
    valor_estimado DECIMAL(10, 2),
    veiculo_id     BIGINT,
    FOREIGN KEY (veiculo_id) REFERENCES veiculos (id) ON DELETE SET NULL
);
