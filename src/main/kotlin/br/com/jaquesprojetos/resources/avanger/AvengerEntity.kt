package br.com.jaquesprojetos.resources.avanger

import br.com.jaquesprojetos.domain.avanger.Avenger
import jakarta.persistence.*

@Entity
@Table(name = "avenger")
data class AvengerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Column(nullable = false) val nick: String,
    @Column(nullable = false) val person: String,
    val description: String?,
    val history: String?,
) {
    fun toAvanger() = Avenger(id, nick, person, description, history)
    
    companion object {
        fun from(avenger: Avenger) = AvengerEntity(
            id = avenger.id,
            nick = avenger.nick,
            person = avenger.person,
            description = avenger.description,
            history = avenger.history
        )
    }
}
