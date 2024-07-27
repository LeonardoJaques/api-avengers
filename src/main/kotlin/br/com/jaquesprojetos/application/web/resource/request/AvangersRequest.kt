package br.com.jaquesprojetos.application.web.resource.request

import br.com.jaquesprojetos.domain.avanger.Avenger
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AvangersRequest(
    @field:NotNull @field:NotEmpty @field:NotBlank val nick: String,
    @field:NotNull @field:NotEmpty @field:NotBlank val person: String,
    val description: String? = null,
    val history: String? = null,
) {
    fun toAvanger() = Avenger(
        nick = nick,
        person = person,
        description = description,
        history = history
    )
    companion object{
       fun to(id: Long?, request: AvangersRequest) = Avenger(
           id = id ,
           nick = request.nick,
           person = request.person,
           description = request.description,
           history = request.history
       )
    }
}



