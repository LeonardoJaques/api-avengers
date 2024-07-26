package br.com.jaquesprojetos.application.web.resource.request

import br.com.jaquesprojetos.domain.avanger.Avanger
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AvangersRequest(
    @field:NotNull @field:NotEmpty @field:NotBlank val nick: String,
    @field:NotNull @field:NotEmpty @field:NotBlank val person: String,
    val description: String? = "",
    val history: String? = "",
) {
    fun toAvanger() = Avanger(
        nick = nick,
        person = person,
        description = description,
        history = history
    )
    companion object{
       fun to(id: Long?, request: AvangersRequest) = Avanger(
           id = id ,
           nick = request.nick,
           person = request.person,
           description = request.description,
           history = request.history
       )
    }
}



