package br.com.jaquesprojetos.resources.avanger

import br.com.jaquesprojetos.domain.avanger.Avanger
import br.com.jaquesprojetos.domain.avanger.AvangerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AvangerRepositoryImpl(
    @Autowired private val repository: AvangerEntitiyRepository, // Autowired is a Spring annotation that injects the object dependency implicitly. It internally uses setter or constructor to inject the dependency.
) : AvangerRepository {
    override fun getDetails(id: Long?): Avanger? =
        repository.findByIdOrNull(id)?.toAvanger()
    
    
    override fun getAvangers(): List<Avanger> =
        repository.findAll().map { it.toAvanger() }
    
    override fun create(avanger: Avanger): Avanger =
        repository.save(AvangerEntity.from(avanger)).toAvanger()
    
    override fun delete(id: Long) = repository.deleteById(id)
    
    override fun update(avanger: Avanger): Avanger =
        repository.save(AvangerEntity.from(avanger)).toAvanger()
    
}