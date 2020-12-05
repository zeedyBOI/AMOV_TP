package pt.isec.amov_tp

import java.io.Serializable


data class ShoppingList(var name : String, var listItems : MutableList<Item>) : Serializable {
    var totalPrice = "0.0"
    constructor(name: String, priceString: String, items: MutableList<Item>) : this(name, items) {
        if (items.isNullOrEmpty())
            listItems = mutableListOf()
        totalPrice = priceString
    }

    fun addItem(item : Item) : Boolean{
        return listItems.add(item)
    }

    override fun toString(): String {
        return "ShoppingList: $name, $listItems"
    }
}