package pt.isec.amov_tp.data

import java.io.Serializable

data class Data(var productsList: ArrayList<Product>, var shopList: ArrayList<ShoppingList>, var categoryList: ArrayList<String>, var unitList: ArrayList<String>) : Serializable {
    fun addList(list : ShoppingList) { shopList.add(list) }
    fun addProduct(product : Product) { productsList.add(product) }
    fun addCategory(category : String) { categoryList.add(category) }
    fun addUnit(unit: String) { unitList.add(unit) }
}