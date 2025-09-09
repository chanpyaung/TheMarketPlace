package com.chanpyaung.themarketplace.data

import okhttp3.Interceptor
import okhttp3.Response

class OAuthInterceptor : Interceptor {

    companion object {
        private const val KEY = "your_key"
        private const val SECRET = "your_secret"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val oauthHeader = buildOAuthHeader()
        val newRequest = original.newBuilder()
            .header("Authorization", oauthHeader)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .build()
        return chain.proceed(newRequest)
    }

    private fun buildOAuthHeader(): String {
        return "OAuth oauth_consumer_key=$KEY," +
                "oauth_signature_method=PLAINTEXT," +
                "oauth_signature=$SECRET&"
    }
}