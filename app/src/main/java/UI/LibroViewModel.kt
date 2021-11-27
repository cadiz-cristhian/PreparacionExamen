package UI

import Data.Libro
import Network.RepositorioLibros
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LibroViewModel : ViewModel(){
    var  libroModel : MutableLiveData<List<Libro>>
    val repo = RepositorioLibros()
            init{
                libroModel = MutableLiveData()
            }
    fun onCreate()
    {
        viewModelScope.launch {
            val result = repo.getAllLibros()
            if(!result.isNullOrEmpty()){
                libroModel.postValue(result)
            }
        }
    }


}