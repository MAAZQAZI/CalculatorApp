package com.example.ktorapicallpersonaldata.network

import com.example.ktorapicallpersonaldata.model.Users

interface ApiService {
    suspend fun getUser(userId: Int): Users
}