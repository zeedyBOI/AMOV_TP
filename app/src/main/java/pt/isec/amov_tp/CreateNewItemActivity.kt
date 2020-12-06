package pt.isec.amov_tp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_create_new_item.*
import kotlinx.android.synthetic.main.activity_create_new_list.*
import pt.isec.amov_tp.data.Data
import pt.isec.amov_tp.data.Product
import kotlin.random.Random

class CreateNewItemActivity : AppCompatActivity() {
    var data = Data(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_item)
        data.startData()
        var list = arrayListOf<String>()
        list.add("No Template")
        for (x in data.productsList)
            list.add(x.description)
        var dataAdapter = ArrayAdapter<String>(this, R.layout.spinner_item, list)
        spinner_items.adapter = dataAdapter
    }

    fun onCreateItem(view: View) {
        if (spinner_items.selectedItem == "No Template") {
            val intent = Intent(this, ProductCreatorActivity::class.java)
            intent.putExtra("productName", et_create_new_item.text.toString())
            startActivity(intent)
        }
        else
            TODO("not implemented")
    }

    fun onCancelItem(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}