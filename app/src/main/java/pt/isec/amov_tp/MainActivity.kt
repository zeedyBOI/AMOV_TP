package pt.isec.amov_tp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val data = Data(mutableListOf(), mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..10)
            data.itemsList.add(Item(Category.BEBIDA, getStr(5, 10), "", getStr(1,3), "", listOf(), ""))
        val list1 = ShoppingList("Continente","€10,55", mutableListOf())
        val list2 = ShoppingList("Minipreço", "€20,42", mutableListOf())
        val list3 = ShoppingList("Lidl", "€420.69", mutableListOf())
        data.shopList.add(list1)
        data.shopList.add(list2)
        data.shopList.add(list3)
        shoppingList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        shoppingList.adapter = RVAdapter(data)
    }

    fun getStr(minc:Int,maxc: Int) : String {
        var str = ""
        val nrc = Random.nextInt(minc,maxc)
        repeat(nrc) {
            str += Random.nextInt(65,90).toChar()
        }
        return str
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun getShoppingList(view: View) : ShoppingList? {
        var listName = view.findViewById<TextView>(R.id.list_name)
        data.shopList.forEach {
            if (it.name.equals(listName))
            return it
        }
        return null
    }

    fun onShoppingList(view: View?) {
        val intent = Intent(this, ListItemsActivity::class.java)
        intent.putExtra("list", getShoppingList(view!!.findViewById(R.id.list_name)))
        startActivity(intent)
    }

    fun onAddNewList(view: View?) {
        val dialog = AlertDialog.Builder(this).setTitle("New List").setView(R.layout.new_list_dialog).setIcon(android.R.drawable.ic_menu_add)
                .setSingleChoiceItems(data.itemsList.map { it -> it.toString() }.toTypedArray(), 0, DialogInterface.OnClickListener{ dialog, which ->
                    Toast.makeText(this,"Item: $which",Toast.LENGTH_LONG).show()
                })
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this,"Carreguei...",Toast.LENGTH_LONG).show()
                })
                .setCancelable(false)
                .create()

        dialog.show()
    }

    class RVAdapter(val data : Data) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var list_title : TextView = view.findViewById(R.id.list_name)
            var list_price : TextView = view.findViewById(R.id.list_price)

            fun update(str1 : String, str2 : String) {
                list_title.text = str1
                list_price.text = str2
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.update(data.shopList[position].name, data.shopList[position].totalPrice)
        }

        override fun getItemCount(): Int = data.shopList.size

    }
}