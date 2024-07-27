package br.com.jaquesprojetos.resources.avanger

import br.com.jaquesprojetos.domain.avanger.Avenger
import br.com.jaquesprojetos.domain.avanger.AvengerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AvengerRepositoryImpl(
    @Autowired private val repository: AvengerEntityRepository, // Autowired is a Spring annotation that injects the object dependency implicitly. It internally uses setter or constructor to inject the dependency.
) : AvengerRepository {
    override fun getDetails(id: Long?): Avenger? =
        repository.findByIdOrNull(id)?.toAvanger()
        
    override fun getAvengers(): List<Avenger> =
        repository.findAll().map { it.toAvanger() }
    
    override fun create(avenger: Avenger): Avenger =
        repository.save(AvengerEntity.from(avenger)).toAvanger()
    
    override fun delete(id: Long) = repository.deleteById(id)
    
    override fun update(avenger: Avenger): Avenger =
        repository.save(AvengerEntity.from(avenger)).toAvanger()
    
}