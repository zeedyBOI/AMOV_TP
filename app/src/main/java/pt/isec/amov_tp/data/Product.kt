package pt.isec.amov_tp.data

data class Product(var description: String, var priceHistory : ArrayList<Double>, var notes: String = "", var brand: String = "Generic", var category: String = "", var srcimg : String = "null")