package br.com.warnit.address.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
class Estado(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)var id: Long? = null,
             @Column(length = 25, nullable = false)
             var nome: String? = null,
             @Column(length = 2, nullable = false)
             var uf: String? = null,
             @JsonBackReference
             @OneToMany
             var cidades: List<Cidade> = emptyList())