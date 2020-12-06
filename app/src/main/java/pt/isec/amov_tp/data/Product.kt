package pt.isec.amov_tp.data

data class Product(var description: String, var priceHistory : ArrayList<Double>, var notes: String = "", var brand: String = "Generic", var category: String = "", var srcimg : String = "null"){
    override fun toString(): String {
        return "Product(description='$description', priceHistory=$priceHistory, notes='$notes', brand='$brand', category='$category', srcimg='$srcimg')"
    }

    fun toStringSmall() : String {
        return description;
    }
}
