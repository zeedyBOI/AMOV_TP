package pt.isec.amov_tp.data

import java.io.Serializable

data class Item(val category : String, var designation : String, var brand : String = "Any", var quantity : String, var srcImage : String = "null", var priceHistory : ArrayList<Double>, var notes : String) : Serializable {


    override fun toString(): String {
        return "Item(category=$category, designation='$designation', brand='$brand', quantity='$quantity', priceHistory=$priceHistory, notes='$notes')"
    }

    fun toStringSmall() : String {
        return designation;
    }
}
