package UI

import Data.LibroProvider
import UI.Adapters.LibroAdapter
import com.example.preparacionexamen.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.preparacionexamen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // se declara el viewBinding
    private lateinit var binding : ActivityMainBinding
    // se declara el viewModel
    private val libroViewModel : LibroViewModel by viewModels()
    // se declara el adapter
    lateinit var adapter : LibroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initViewModel()
    }
    private fun initRecyclerView()
    {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = LibroAdapter(this)
        binding.recyclerView.adapter = adapter
    }
    private fun initViewModel()
    {
        val viewModel : LibroViewModel = ViewModelProvider(this).get(LibroViewModel::class.java)
        viewModel.libroModel.observe(this, Observer{
            if(it != null)
            {
                adapter.cargarLibros(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Error al cargar la lista", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.onCreate()
    }
}