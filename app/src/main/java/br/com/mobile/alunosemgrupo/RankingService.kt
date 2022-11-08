package br.com.mobile.alunosemgrupo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object RankingService {
    val host = "https://www.jsonkeeper.com/b/DS51"

    fun getRanking(): List<RankingBuilder>{
        var place = ArrayList<RankingBuilder>()

        if (AndroidUtils.isInternetDisponivel()){
        val url = "$host"
            val json = HttpHelper.get(url)
            place = parserJson<ArrayList<RankingBuilder>>(json)

            for (p in place) {
                saveOffline(p)
            }
            return place
        } else {
            val dao = DatabaseManager.getRankingDAO()
            val place = dao.findAll()
            return place
        }
    }

    fun getDisciplina (id: Long): RankingBuilder? {

        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/${id}"
            val json = HttpHelper.get(url)
            return parserJson<RankingBuilder>(json)

        } else {
            val dao = DatabaseManager.getRankingDAO()
            val place = dao.getById(id)
            return place
        }

    }

    fun save(place: RankingBuilder): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/disciplinas", place.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(place)
            return Response("OK", "Disciplina salva no dispositivo")
        }
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }


    fun saveOffline(ranking: RankingBuilder) : Boolean {
        val dao = DatabaseManager.getRankingDAO()

        if (! rankingExist(ranking)) {
            dao.insert(ranking)
        }

        return true

    }
    fun rankingExist(ranking: RankingBuilder): Boolean {
        val dao = DatabaseManager.getRankingDAO()
        return dao.getById(ranking.id) != null
    }
}
