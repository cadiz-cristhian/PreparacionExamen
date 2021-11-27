package Network

import Data.Libro
import Data.LibroDetalle
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LibroService {
    private val retrofit = ApiLibros.getRetrofit()
    private val service : ApiClient = retrofit.create(ApiClient::class.java)
    val libroDetalle = MutableLiveData<LibroDetalle>()

    suspend fun getLibro() : List<Libro>
    {
        return withContext(Dispatchers.IO)
        {
            val response = service.getLibros()
            response.body() ?: emptyList()
        }
    }
}
