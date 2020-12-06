package pt.isec.amov_tp

import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_items.*
import kotlinx.android.synthetic.main.create_item_dialog.*
import kotlinx.android.synthetic.main.item.*
import pt.isec.amov_tp.data.*
import kotlin.random.Random

class ListItemsActivity : AppCompatActivity(), RVAdapterItem.OnItemClickListener, RVAdapterItem.OnCheckedChangeListener {
    var data : Data = Data(arrayListOf(), arrayListOf(), arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_items)
        val listName = intent.getStringExtra("listName")
        list_title.text = listName
        listName?.let { ShoppingList(it, arrayListOf()) }?.let { data.addList(it) }
        for (x in 1..20)
            data.shopList[0].listItems.add(Item(Product(getStr(5,10), arrayListOf(1.0, 5.0, 999.99), "notes", "brand", "category", "image"),
                    Quantity(1.0, "caixas"), false))
        var mockList = data.shopList[0].listItems
        items_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        items_list.adapter = RVAdapterItem(mockList, this, this)
    }

    override fun onNavigateUp(): Boolean {
        onBackPressed()
        return true
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

    /*fun onAddNewItem(view: View?) {
        var products = arrayListOf<String>()
        for (x in data.productsList)
            products.add(x.description)
        val view = LayoutInflater.from(this).inflate(R.layout.create_item_dialog, null)
        var dataAdapter = ArrayAdapter<String>(this, R.layout.spinner_list_item, products)
        spinner_items_dialog.adapter = dataAdapter
        val dialog = AlertDialog.Builder(this).setTitle("New Item").setView(view).setIcon(android.R.drawable.ic_menu_add)
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                    var edit = view.findViewById<EditText>(R.id.eT_newItem)
                    Toast.makeText(this,"${edit.text} created", Toast.LENGTH_LONG).show()
                })
                .setNeutralButton("Create New Item", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "Create New Item", Toast.LENGTH_LONG).show()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this,"" + "Cancel", Toast.LENGTH_LONG).show()
                })
                .setCancelable(true)
        dialog.create().show()
    }*/

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_LONG).show()
    }

    override fun onCheckChanged(position: Int) {
        Toast.makeText(this, "Item $position checked", Toast.LENGTH_SHORT).show()
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