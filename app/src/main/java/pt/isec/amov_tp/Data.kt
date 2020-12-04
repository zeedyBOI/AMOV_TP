package pt.isec.amov_tp

import java.io.Serializable

class Data(var itemsList: MutableList<Item>, var shopList: MutableList<ShoppingList>) : Serializable{
    fun addList(list : ShoppingList) { shopList.add(list)}
    fun addItem(item : Item) { itemsList.add(item)}
}