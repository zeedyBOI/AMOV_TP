package pt.isec.amov_tp.data

import java.io.Serializable

data class Item(var product: Product, var quantity : Quantity, var inCart : Boolean = false) : Serializable {


    override fun toString(): String {
        return "Item(category=$product.category, description='$product.description', brand='$product.brand', quantity='$quantity', priceHistory=${product.priceHistory}, notes='$product.notes')"
    }

    fun toStringSmall() : String {
        return product.description;
    }
}
