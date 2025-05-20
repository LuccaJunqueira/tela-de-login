package com.example.myapplication.loginapp

import java.io.*
import java.net.HttpURLConnection
import java.net.URL

object HttpHelper {
    fun login(email: String, senha: String): String {
        val url = URL("http://10.0.2.2:5000/login")
        val jsonBody = """{"email":"$email", "senha":"$senha"}"""

        return try {
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.setRequestProperty("Content-Type", "application/json")
            conn.doOutput = true

            val output = conn.outputStream
            output.write(jsonBody.toByteArray())
            output.flush()
            output.close()

            val responseCode = conn.responseCode
            val reader = BufferedReader(InputStreamReader(
                if (responseCode in 200..299) conn.inputStream else conn.errorStream
            ))
            val response = reader.readText()
            reader.close()

            // Extrai mensagem do JSON
            val json = JSONObject(response)
            json.getString("mensagem")

        } catch (e: Exception) {
            "Erro: ${e.message}"
        }
    }
}