package pt.isec.amov_tp

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data = arrayListOf<ShoppingList>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(findViewById(R.id.toolbar))

        val list1 = ShoppingList("Continente","€10,55", null)
        val list2 = ShoppingList("Minipreço", "€20,42", null)
        val list3 = ShoppingList("Lidl", "€420.69", null)
        data.add(list1)
        data.add(list2)
        data.add(list3)
        shoppingList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        shoppingList.adapter = RVAdapter(data)
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

    class RVAdapter(val data : ArrayList<ShoppingList>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
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
            holder.update(data[position].name, data[position].totalPrice)
        }

        override fun getItemCount(): Int = data.size

    }
}