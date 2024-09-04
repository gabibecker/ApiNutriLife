package example.com.database.dao

import example.com.model.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DietaDao {
    suspend fun getUserPreferences(id: Int, data: Int): List<Int> = dbQuery {
        Dietas.selectAll().where { (Dietas.idUser eq id) and (Dietas.diadaSemana eq data) }.map {
            it[Dietas.idReceita]
        }
    }

    suspend fun getUserDiet(userId: Int): List<Dieta> = dbQuery {
        Dietas.selectAll().where { Dietas.idUser eq userId }
            .map {
                Dieta(
                    idDieta = it[Dietas.idDieta],
                    idUser = it[Dietas.idUser],
                    idReceita = it[Dietas.idReceita],
                    diadaSemana = it[Dietas.diadaSemana]
                )
            }
    }

    suspend fun addDiet(dietas: List<Dieta>) = dbQuery {
        Dietas.batchInsert(dietas) { dieta ->
            this[Dietas.idUser] = dieta.idUser
            this[Dietas.idReceita] = dieta.idReceita
            this[Dietas.diadaSemana] = dieta.diadaSemana
        }
    }

    suspend fun deleteUserDieta(idUser: Int): Boolean = dbQuery {
        Dietas.deleteWhere { Dietas.idUser eq idUser+3000 } > 0
    }
}
