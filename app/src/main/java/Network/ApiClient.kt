package Network

import Data.Libro
import Data.LibroDetalle
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("books")
    suspend fun getLibros() : Response<List<Libro>>

    @GET("bookDetail/{id}")
     fun getDetalle(@Path("id") id : Int) : Call<LibroDetalle>







}
