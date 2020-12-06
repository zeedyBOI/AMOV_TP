package pt.isec.amov_tp.data

import java.io.Serializable

data class ShoppingList(var name : String, var listItems : ArrayList<Item>) : Serializable {

    constructor(name: String, priceString: String, items: ArrayList<Item>) : this(name, items) {
        if (items.isNullOrEmpty())
            listItems = arrayListOf()
    }

    fun addItem(item : Item) : Boolean{
        return listItems.add(item)
    }

    fun getTotalPrice() : Double{
        var totalPrice : Double = 0.00
        for(index in listItems) {
            totalPrice += index.product.priceHistory[0]
        }

        return totalPrice
    }

    override fun toString(): String {
        return "ShoppingList: $name, $listItems"
    }

}