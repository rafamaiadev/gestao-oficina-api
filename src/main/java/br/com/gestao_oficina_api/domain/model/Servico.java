package br.com.gestao_oficina_api.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double precoBase;

    private Integer duracaoMedia;

    @ManyToMany(mappedBy = "servicos")
    private List<OrdemServico> ordensServico;
}