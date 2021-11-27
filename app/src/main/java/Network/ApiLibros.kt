package Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiLibros {
    fun getRetrofit(): retrofit2.Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/Himuravidal/anchorBooks/")
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
    }
}