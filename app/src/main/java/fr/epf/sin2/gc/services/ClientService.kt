package fr.epf.sin2.gc.services

import retrofit2.http.GET

interface ClientService {

    @GET("api/?results=20")
    suspend fun listClients() : ListClientsResponse
}

data class ListClientsResponse(val results: List<User>)
data class User(val gender: String, val name: Name, val picture: Picture)
data class Name(val last: String, val first: String)

data class Picture(val thumbnail: String)