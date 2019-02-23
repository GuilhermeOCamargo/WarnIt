package br.com.warnit.address.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
@Entity
class Localidade(@Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 var id: Long? = null,
                 @Column(length = 25, nullable = false, unique = true)
                 var nomeRua: String? = null,
                 @JsonManagedReference
                 @ManyToOne(cascade= [CascadeType.PERSIST, CascadeType.REFRESH])
                 @JoinColumn(name = "bairro_id", nullable = false)
                 var bairro: Bairro? = null,
                 @Column(length=8, nullable=false, unique = true)
                 var cep: String? = null)