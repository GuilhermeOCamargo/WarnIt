package br.com.warnit.address.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
@Entity
class Bairro(@Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
             var id: Long? = null,
             @Column(length = 25, nullable = false)
             var nome: String? = null,
             @JsonManagedReference
             @ManyToOne(optional=false, cascade= [CascadeType.PERSIST, CascadeType.REFRESH])
             @JoinColumn(name = "cidade_id")
             var cidade: Cidade? = null,
             @JsonBackReference
             @OneToMany
             var localidades: List<Localidade> = emptyList() )
