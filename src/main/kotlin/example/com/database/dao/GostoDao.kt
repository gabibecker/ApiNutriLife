package example.com.database.dao

import example.com.model.Dietas
import example.com.model.Gosto
import example.com.model.Gostos
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class GostosDao {
    suspend fun getUserPreferences(id: Int): List<Gosto> = dbQuery {
        Gostos.selectAll().where { Gostos.idUser eq id }
            .map {
                Gosto(
                    idGostos = it[Gostos.idGostos],
                    idUser = it[Gostos.idUser],
                    idIngrediente = it[Gostos.idIngrediente],
                )
            }
    }

    suspend fun setUserPreference(lista: MutableList<Gosto>) {
        for (gosto in lista) {
            dbQuery {
                Gostos.insert {
                    it[idGostos] = gosto.idGostos
                    it[idUser] = gosto.idUser
                    it[idIngrediente] = gosto.idIngrediente
                }
            }
        }
    }

    suspend fun deleteUserGosto(idUser: Int): Boolean = dbQuery {
        Gostos.deleteWhere { Gostos.idUser eq idUser } > 0
    }
}

