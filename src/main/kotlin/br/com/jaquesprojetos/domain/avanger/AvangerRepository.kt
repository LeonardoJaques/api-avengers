package br.com.jaquesprojetos.domain.avanger

interface AvangerRepository {
    fun getDetails(id: Long?): Avanger?
    fun getAvangers(): List<Avanger>
    fun create(avanger: Avanger): Avanger
    fun delete(id: Long)
    fun update(avanger: Avanger): Avanger
}