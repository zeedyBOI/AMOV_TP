package pt.isec.amov_tp

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class ShoppingList(var name : String, var listItems : ArrayList<Item>) : Serializable {
    var totalPrice = "0.0"
    constructor(name: String, priceString: String, items: ArrayList<Item>) : this(name, items) {
        if (items.isNullOrEmpty())
            listItems = arrayListOf()
        totalPrice = priceString
    }

    fun addItem(item : Item) : Boolean{
        return listItems.add(item)
    }

    override fun toString(): String {
        return "ShoppingList: $name, $listItems"
    }
}