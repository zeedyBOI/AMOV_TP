package pt.isec.amov_tp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_new_list.*
import pt.isec.amov_tp.data.Data
import pt.isec.amov_tp.data.Product
import pt.isec.amov_tp.data.ShoppingList
import kotlin.random.Random

class CreateNewListActivity : AppCompatActivity() {
    var data : Data = Data(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_list)
        data.startData()
        var list = arrayListOf<String>()
        list.add("No Template")
        for (x in data.shopList)
            list.add(x.name)
        var dataAdapter = ArrayAdapter<String>(this, R.layout.spinner_list_item, list)
        spinner_lists.adapter = dataAdapter
    }


    fun onCreateList(view: View) {
        data.addList(ShoppingList(et_create_new_list.text.toString(), arrayListOf()))
        Toast.makeText(this, "list named: " + et_create_new_list.text + " based on:" + spinner_lists.selectedItem, Toast.LENGTH_LONG).show()
        val intent = Intent(this, ListItemsActivity::class.java)
        intent.putExtra("listName", data.shopList.last().name)
        startActivity(intent)
        finish()
    }

    fun onCancelList(view: View) {
        finish()
    }
}