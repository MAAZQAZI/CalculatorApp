package com.example.ktorapicallpersonaldata.network

object ApiFactory {
    fun createApiService(): ApiService {
        return ApiServiceImp(ApiClient.client)
    }
}