package com.example.ktorapicallpersonaldata.network

import com.example.ktorapicallpersonaldata.model.Users
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class ApiServiceImp(private val client: HttpClient) : ApiService    {
    override suspend fun getUser(userId: Int): Users {
        return client.get("https://dummyjson.com/users/${userId.toString()}").body()
    }
}