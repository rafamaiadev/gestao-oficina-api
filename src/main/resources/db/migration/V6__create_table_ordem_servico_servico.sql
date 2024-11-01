CREATE TABLE ordem_servico_servico
(
    ordem_servico_id BIGINT,
    servico_id       BIGINT,
    PRIMARY KEY (ordem_servico_id, servico_id),
    FOREIGN KEY (ordem_servico_id) REFERENCES ordens_servico (id) ON DELETE CASCADE,
    FOREIGN KEY (servico_id) REFERENCES servicos (id) ON DELETE CASCADE
);
