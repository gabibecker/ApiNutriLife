package example.com.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class IngredienteDaReceita(
    val id: Int,
    val idReceita: Int,
    val idIngrediente: Int
)

object IngredienteDaReceitas : Table() {
    val id = integer("id").autoIncrement()
    val idReceita = integer("idReceita")
    val idIngrediente = integer("idIngrediente")

    override val primaryKey = PrimaryKey(id)
}