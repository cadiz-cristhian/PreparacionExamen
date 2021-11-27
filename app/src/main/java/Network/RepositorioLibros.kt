package Network

import Data.Libro
import Data.LibroDetalle
import Data.LibroProvider


class RepositorioLibros {
    private val api = LibroService()
    private var libros = LibroProvider.libros

    suspend fun getAllLibros():List<Libro>{
        val response = api.getLibro()
        libros = response
        return response
    }




}