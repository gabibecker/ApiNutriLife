package example.com.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Gosto(
    val idGostos: Int,
    val idUser: Int,
    val idIngrediente: Int
)


object Gostos : Table() {
    val idGostos = integer("idGostos")
    val idUser = integer("idUser")
    val idIngrediente = integer("idIngrediente")

    override val primaryKey = PrimaryKey(idGostos)
}
