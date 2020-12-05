package pt.isec.amov_tp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_create_new_list.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.EOFException
import java.io.FileNotFoundException
import java.io.ObjectInputStream
import kotlin.random.Random

class CreateNewList : AppCompatActivity() {
    var data : Data = Data(arrayListOf(), arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_list)
        for (i in 1..20)
            data.itemsList.add(Item("BEBIDA", getStr(5, 10), "", getStr(1,3), "", arrayListOf(), ""))
        val list1 = ShoppingList("Continente","€10,55", arrayListOf())
        val list2 = ShoppingList("Minipreço", "€20,42", arrayListOf())
        val list3 = ShoppingList("Lidl", "€420.69", arrayListOf())
        data.shopList.add(list1)
        data.shopList.add(list2)
        data.shopList.add(list3)
        var list = arrayListOf<String>()
        for (x in data.shopList)
            list.add(x.name)
        var dataAdapter = ArrayAdapter<String>(this, R.layout.spinner_list_item, list)
        spinner_lists.adapter = dataAdapter
    }


    fun onCreateList(view: View) {
        var eText = et_create_new_list
        data.shopList.add(ShoppingList(eText.text.toString(), "9.99", arrayListOf()))
        Toast.makeText(this, et_create_new_list.text.toString(), Toast.LENGTH_LONG).show()
    }


    fun getStr(minc:Int,maxc: Int) : String {
        var str = ""
        val nrc = Random.nextInt(minc,maxc)
        repeat(nrc) {
            str += Random.nextInt(65,90).toChar()
        }
        return str
    }
}