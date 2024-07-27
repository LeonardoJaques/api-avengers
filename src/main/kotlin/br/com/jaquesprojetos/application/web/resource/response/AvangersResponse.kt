package br.com.jaquesprojetos.application.web.resource.response

import br.com.jaquesprojetos.domain.avanger.Avenger

data class AvangersResponse(
    val id: Long?,
    val nick: String,
    val person: String,
    val description: String?,
    val history: String?,
){
    companion object {
        fun from(avenger: Avenger) = AvangersResponse(
            id = avenger.id,
            nick = avenger.nick,
            person = avenger.person,
            description = avenger.description,
            history = avenger.history
        )
    }
}
