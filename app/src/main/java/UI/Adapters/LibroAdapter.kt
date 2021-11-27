package UI.Adapters

import Data.Libro
import UI.Detalle
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.preparacionexamen.databinding.RecyclerviewLibrosBinding

class LibroAdapter(private val activity : Activity) : RecyclerView.Adapter<LibroAdapter.LibroViewHolder>(){
    private var libros: List<Libro> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val binding: RecyclerviewLibrosBinding = RecyclerviewLibrosBinding.inflate(LayoutInflater.from(activity))
        return LibroViewHolder(binding)

    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        val id = libro.id
        holder.title.text = libro.title
        holder.author.text = libro.author
        Glide.with(activity).load(libro.imageLink).into(holder.imageLink)
        holder.detalle.setOnClickListener {
            val siguiente = Intent(activity, Detalle::class.java)
            siguiente.putExtra("id",id)
            activity.startActivity(siguiente)
        }



    }

    override fun getItemCount(): Int {
        return libros.size
    }
    fun cargarLibros(list: List<Libro>)
    {
        libros = list
        notifyDataSetChanged()
    }
    class LibroViewHolder (view: RecyclerviewLibrosBinding) : RecyclerView.ViewHolder(view.root)
    {
            val title = view.txtNombreLibro
            val author = view.txtSubtexto
            val imageLink = view.ivPoster
            val detalle = view.txtRevisar
    }

}