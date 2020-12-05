package pt.isec.amov_tp.data

import java.io.Serializable

class Data(var itemsList: ArrayList<Item>, var shopList: ArrayList<ShoppingList>) : Serializable {
    fun addList(list : ShoppingList) { shopList.add(list)}
    fun addItem(item : Item) { itemsList.add(item)}
}