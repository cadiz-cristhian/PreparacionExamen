package UI

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.preparacionexamen.databinding.ActivityDetalleBinding

class Detalle : AppCompatActivity() {

    private lateinit var binding : ActivityDetalleBinding
    lateinit var detalleViewModel: DetalleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        enviarCorreo()



    }
    private fun initViewModel(){
        val viewModel : DetalleViewModel = ViewModelProvider(this).get(DetalleViewModel::class.java)
        val id = intent.extras?.get("id") as Int
        viewModel.getDetalle(id)
        viewModel.libroDetalle.observe(this, Observer { detalleLibro ->
            binding.txtTituloDetalle.text = detalleLibro.title
            Glide.with(this).load(detalleLibro.imageLink).into(binding.ivPosterDetalle)
            binding.txtAutor.text = detalleLibro.author
            binding.txtPais.text = detalleLibro.country
            binding.txtLenguaje.text = detalleLibro.language
            binding.txtPaginas.text = detalleLibro.pages
            binding.txtAno.text = detalleLibro.year
            binding.txtPrecio.text = detalleLibro.price
            binding.txtUltimoPrecio.text = detalleLibro.lastPrice
            if(detalleLibro.delivery) { binding.txtDelivery.text = "Cuenta con despacho"}else{
                binding.txtDelivery.text = "Sin Despacho"
            }
        })

    }
    private fun enviarCorreo(){
        binding.btnEnviar.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:")
            intent.type= "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL,"ventas@anchorBooks.cl")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta por libro")
            startActivity(intent)
        }

    }
}