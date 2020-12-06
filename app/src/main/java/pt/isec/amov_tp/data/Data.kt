package pt.isec.amov_tp.data

import java.io.Serializable

data class Data(var productsList: ArrayList<Product>, var shopList: ArrayList<ShoppingList>, var categoryList: ArrayList<String>, var unitList: ArrayList<String>) : Serializable {
    fun startData() {
        addCategory("Bebida")
        addCategory("Carne")
        addCategory("Peixe")
        addCategory("Cereais")
        addCategory("Laticinios")
        addUnit("Kg")
        addUnit("L")
        addUnit("Unidades")
        addUnit("Caixas")
        addProduct(Product("Leite", arrayListOf(0.69, 0.57), "", "Gresso", categoryList.get(4), ""))
        addProduct(Product("Frango", arrayListOf(3.99, 2.99, 3.99), "", "Talho", categoryList.get(1), ""))
        addProduct(Product("Salmao", arrayListOf(5.99, 6.99), "", "Peixaria", categoryList.get(2), ""))
        addList(ShoppingList("Continente", arrayListOf(Item(productsList.get(0), Quantity(1.0, unitList.get(1)), false))))
        addList(ShoppingList("Lidl", arrayListOf(Item(productsList.get(2), Quantity(2.0, unitList.get(0)), false), Item(productsList.get(0), Quantity(3.0, unitList.get(2)), false))))
    }

    fun addList(list : ShoppingList) { shopList.add(list) }
    fun addProduct(product : Product) { productsList.add(product) }
    fun addCategory(category : String) { categoryList.add(category) }
    fun addUnit(unit: String) { unitList.add(unit) }
}