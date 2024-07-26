package br.com.jaquesprojetos.application.web.resource.response

import br.com.jaquesprojetos.domain.avanger.Avanger

data class AvangersResponse(
    val id: Long?,
    val nick: String,
    val person: String,
    val description: String?,
    val history: String?,
){
    companion object {
        fun from(avanger: Avanger) = AvangersResponse(
            id = avanger.id,
            nick = avanger.nick,
            person = avanger.person,
            description = avanger.description,
            history = avanger.history
        )
    }
}
