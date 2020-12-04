package pt.isec.amov_tp

enum class Category{
    LATICINIOS, CARNE, PEIXE, CASA, HIGIENE, BEBIDA
}

data class Item(val category : Category, var designation : String, var brand : String = "Any", var quantity : String, var srcImage : String = "null", var priceHistory : List<Double>, var notes : String) {
    override fun toString(): String {
        return "Item(category=$category, designation='$designation', brand='$brand', quantity='$quantity', priceHistory=$priceHistory, notes='$notes')"
    }
}
