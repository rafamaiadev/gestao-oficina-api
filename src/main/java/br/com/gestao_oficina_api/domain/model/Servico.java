package br.com.gestao_oficina_api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private BigDecimal precoBase;

    private Integer duracaoMedia;

    @ManyToMany(mappedBy = "servicos")
    @JsonIgnore
    private List<OrdemServico> ordensServico;
}