package pt.isec.amov_tp

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*
import pt.isec.amov_tp.data.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), RVAdapterList.OnItemClickListener, RVAdapterList.OnCheckedChangeListener {
    var data : Data = Data(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0..20)
            data.productsList.add(Product(getStr(5, 10), arrayListOf(), "notes", "brand", "category", "image"))
        val list1 = ShoppingList("Continente","€10,55", arrayListOf(Item(data.productsList.get(1), Quantity(1.0, "caixa"), false)))
        val list2 = ShoppingList("Minipreço", "€20,42", arrayListOf())
        val list3 = ShoppingList("Lidl", "€420.69", arrayListOf())
        data.shopList.add(list1)
        data.shopList.add(list2)
        data.shopList.add(list3)
        shoppingList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        shoppingList.adapter = RVAdapterList(data, this, this)
    }

    fun getStr(minc:Int,maxc: Int) : String {
        var str = ""
        val nrc = Random.nextInt(minc,maxc)
        repeat(nrc) {
            str += Random.nextInt(65,90).toChar()
        }
        return str
    }

    private fun getShoppingList(view: View) : ShoppingList? {
        var listName = view.findViewById<TextView>(R.id.list_name)
        data.shopList.forEach {
            if (it.name.equals(listName))
            return it
        }
        return null
    }

    fun onAddNewList(view: View?) {
        val intent = Intent(this, CreateNewList::class.java)
        startActivity(intent)
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, ListItemsActivity::class.java)
        intent.putExtra("listName", data.shopList[position].name)
        startActivity(intent)
        //Toast.makeText(this, "List $position clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onCheckChanged(position: Int) {
        Toast.makeText(this, "List $position checked", Toast.LENGTH_SHORT).show()
    }

}