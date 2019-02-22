package br.com.warnit.address.model

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Estado(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)val id: Long = 0L,
             @Column(length = 25, nullable = false)
             val nome: String = "",
             @Column(length = 2, nullable = false)
             val uf: String = ""){

}

