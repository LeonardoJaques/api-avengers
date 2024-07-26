package br.com.jaquesprojetos.resources.avanger

import br.com.jaquesprojetos.domain.avanger.Avanger
import jakarta.persistence.*

@Entity
data class AvangerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Column(nullable = false) val nick: String,
    @Column(nullable = false) val person: String,
    val description: String?,
    val history: String?,
) {
    fun toAvanger() = Avanger(id, nick, person, description, history)
    
    companion object {
        fun from(avanger: Avanger) = AvangerEntity(
            id = avanger.id,
            nick = avanger.nick,
            person = avanger.person,
            description = avanger.description,
            history = avanger.history
        )
    }
}
