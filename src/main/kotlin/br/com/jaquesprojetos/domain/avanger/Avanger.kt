package br.com.jaquesprojetos.domain.avanger

data class Avanger(
    val id: Long? = null,
    val nick: String,
    val person: String,
    val description: String?,
    val history: String?,
)
