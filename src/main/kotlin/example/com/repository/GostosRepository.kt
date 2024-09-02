package example.com.repository

import example.com.database.dao.GostosDao
import example.com.model.Gosto

class GostosRepository(
    private val dao: GostosDao = GostosDao()
) {
    suspend fun getUserPreferences(id: Int): List<Gosto> = dao.getUserPreferences(id)

    suspend fun setUserPreference(lista: MutableList<Gosto>) = dao.setUserPreference(lista)

    suspend fun deleteUserGosto(idUser: Int) = dao.deleteUserGosto(idUser)

}