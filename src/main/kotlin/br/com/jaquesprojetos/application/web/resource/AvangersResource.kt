package br.com.jaquesprojetos.application.web.resource

import br.com.jaquesprojetos.application.web.resource.request.AvangersRequest
import br.com.jaquesprojetos.application.web.resource.response.AvangersResponse
import br.com.jaquesprojetos.domain.avanger.AvangerRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


private const val API_PATH = "/v1/api/avenger"

@RestController
@RequestMapping(value = [API_PATH])
class AvangersResource(
    @Autowired private val repository: AvangerRepository,
) {
    @GetMapping
    fun getAvangers() =
        repository.getAvangers().map { AvangersResponse.from(it) }
            .let { ResponseEntity.ok().body(it) }
    
    @GetMapping("{id}/detail")
    fun getAvangerDetail(@PathVariable(value = "id") id: Long) =
        repository.getDetails(id)?.let { avanger ->
            ResponseEntity.ok()
                .body(avanger.let { it -> AvangersResponse.from(it) })
        } ?: ResponseEntity.notFound().build()
    
    @PostMapping
    fun createAvanger(@Valid @RequestBody request: AvangersRequest) =
        request.toAvanger().run {
            repository.create(this)
        }.let {
            ResponseEntity.created(URI("$API_PATH/${it.id}"))
                .body(AvangersResponse.from(it))
        }
    
    @PutMapping("{id}")
    fun updateAvanger(
        @PathVariable(value = "id") id: Long,
        @Valid @RequestBody request: AvangersRequest,
    ) = repository.getDetails(id)?.let { avanger ->
        AvangersRequest.to(avanger.id, request).apply {
            repository.update(this)
        }.let {
            ResponseEntity.accepted().body(AvangersResponse.from(it))
        }
    } ?: ResponseEntity.notFound().build()
    
    @DeleteMapping("{id}")
    fun deleteAvanger(@PathVariable(value = "id") id: Long) =
        repository.delete(id).let { ResponseEntity.accepted().build<Unit>() }
    
}
