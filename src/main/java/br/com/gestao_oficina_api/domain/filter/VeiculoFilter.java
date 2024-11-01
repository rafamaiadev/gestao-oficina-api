package br.com.gestao_oficina_api.domain.filter;

public record VeiculoFilter(Long id, String placa, String modelo, Integer anoFabricacao, String tipo, Long clienteId) {
}
