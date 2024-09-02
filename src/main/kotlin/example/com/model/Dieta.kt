package example.com.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Dieta(
    val idDieta: Int,
    val idUser: Int,
    val idReceita: Int,
    val diadaSemana: Int
)

object Dietas : Table() {
    val idDieta = integer("idDieta").autoIncrement()
    val idUser = integer("idUser")
    val idReceita = integer("idReceita")
    val diadaSemana = integer("diadaSemana")
    override val primaryKey = PrimaryKey(idDieta)
}