package br.com.jaquesprojetos.application.web.resource

import br.com.jaquesprojetos.application.web.resource.request.AvangersRequest
import br.com.jaquesprojetos.application.web.resource.response.AvangersResponse
import br.com.jaquesprojetos.domain.avanger.AvengerRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


private const val API_PATH = "/v1/api/avenger"

@RestController
@RequestMapping(value = [API_PATH])
class AvengersResource(
    @Autowired private val repository: AvengerRepository,
) {
    @GetMapping
    fun getAvengers() =
        repository.getAvengers().map { AvangersResponse.from(it) }
            .let { ResponseEntity.ok().body(it) }
    
    @GetMapping("{id}/detail")
    fun getAvengerDetail(@PathVariable(value = "id") id: Long) =
        repository.getDetails(id)?.let { avanger ->
            ResponseEntity.ok()
                .body(avanger.let { it -> AvangersResponse.from(it) })
        } ?: ResponseEntity.notFound().build()
    
    @PostMapping
    fun createAvenger(@Valid @RequestBody request: AvangersRequest) =
        request.toAvanger().run {
            repository.create(this)
        }.let {
            ResponseEntity.created(URI("$API_PATH/${it.id}"))
                .body(AvangersResponse.from(it))
        }
    
    @PutMapping("{id}")
    fun updateAvenger(@PathVariable(value = "id") id: Long, @Valid @RequestBody request: AvangersRequest) =
        request.toAvanger().run {
            repository.update(this.copy(id = id))
        }.let {
            ResponseEntity.ok().body(AvangersResponse.from(it))
        }
    
    @DeleteMapping("{id}")
    fun deleteAvenger(@PathVariable(value = "id") id: Long) =
        repository.delete(id).let { ResponseEntity.accepted().build<Unit>() }
    
}
