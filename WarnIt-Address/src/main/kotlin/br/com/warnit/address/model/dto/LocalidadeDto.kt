package br.com.warnit.address.model.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

class LocalidadeDto(
        var idLocalidade: Long? = null,
        @NotNull(message = "Insira o nome da rua.")
        var nomeRua: String,
        @NotNull(message = "Insira do CEP.")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "Cep inválido.")
        var cep: String,
        var idBairro: Long? = null,
        @NotNull(message = "Insira o bairro.")
        var nomeBairro: String,
        var idCidade: Long? = null,
        @NotNull(message = "Insira a cidade.")
        var nomeCidade: String,
        var idEstado: Long? = null,
        @NotNull(message = "Insira o estado.")
        var nomeEstado: String,
        @NotNull(message = "Insira a UF.")
        @Size(min = 2, max = 2, message = "UF Inválida.")
        var uf: String)