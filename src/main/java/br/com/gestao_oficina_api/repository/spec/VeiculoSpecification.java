package br.com.gestao_oficina_api.repository.spec;

import br.com.gestao_oficina_api.domain.filter.VeiculoFilter;
import br.com.gestao_oficina_api.domain.model.Veiculo;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VeiculoSpecification {

    public static Specification<Veiculo> filterBy(VeiculoFilter filter) {

        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(filter.placa())) {
                predicates.add(builder.like(builder.lower(root.get("placa")), "%" + filter.placa().toLowerCase() + "%"));
            }
            if (Objects.nonNull(filter.modelo())) {
                predicates.add(builder.like(builder.lower(root.get("modelo")), "%" + filter.modelo().toLowerCase() + "%"));
            }
            if (Objects.nonNull(filter.anoFabricacao())) {
                predicates.add(builder.equal(root.get("anoFabricacao"), filter.anoFabricacao()));
            }
            if (Objects.nonNull(filter.tipo())) {
                predicates.add(builder.equal(root.get("tipo"), filter.tipo()));
            }
            if (Objects.nonNull(filter.clienteId())) {
                predicates.add(builder.equal(root.get("cliente").get("id"), filter.clienteId()));
            }

            assert query != null;
            query.orderBy(builder.asc(root.get("modelo")));

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

