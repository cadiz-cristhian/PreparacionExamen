package Data

data class LibroDetalle(
    val id : Int,
    val author : String,
    val country : String,
    val imageLink : String,
    val language : String,
    val link : String,
    val pages : String,
    val title : String,
    val year : String,
    val price : String,
    val lastPrice : String,
    val delivery : Boolean
)
