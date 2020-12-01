package pt.isec.amov_tp

data class ShoppingList(var name : String, var listItems : List<Item>?) {
    var totalPrice = "0.0"
    constructor(name: String, priceString: String, items: List<Item>?) : this(name, items) {
        totalPrice = priceString
    }

    override fun toString(): String {
        return "ShoppingList: $name, $listItems"
    }
}