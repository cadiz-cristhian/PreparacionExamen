package UI

import Data.LibroDetalle
import Network.ApiClient
import Network.ApiLibros
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalleViewModel : ViewModel(){

    private val retrofit = ApiLibros.getRetrofit()
    private val service : ApiClient = retrofit.create(ApiClient::class.java)
    val libroDetalle = MutableLiveData<LibroDetalle>()

    fun getDetalle(id : Int){
        val call = service.getDetalle(id)
        call.enqueue(object : Callback<LibroDetalle> {
            override fun onResponse(
                call: Call<LibroDetalle>,
                response: Response<LibroDetalle>
            ){
                response.body()?.let {
                        detalle -> libroDetalle.postValue(detalle) }}

            override fun onFailure(p0: Call<LibroDetalle>, p1: Throwable) {
                TODO("Not yet implemented")
            }
        }
        )
    }
}