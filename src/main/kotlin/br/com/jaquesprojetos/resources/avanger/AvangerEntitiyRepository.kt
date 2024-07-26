package br.com.jaquesprojetos.resources.avanger

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvangerEntitiyRepository : JpaRepository<AvangerEntity, Long>