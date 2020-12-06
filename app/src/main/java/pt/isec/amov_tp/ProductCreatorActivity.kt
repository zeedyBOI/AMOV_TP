package pt.isec.amov_tp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_product_creator.*
import pt.isec.amov_tp.data.Data
import kotlin.random.Random

class ProductCreatorActivity : AppCompatActivity() {
    var data = Data(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_creator)
        data.startData()
        var adapterCategory = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data.categoryList)
        spinner_category.adapter = adapterCategory
        var adapterUnits = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data.unitList)
        spinner_units.adapter = adapterUnits
    }

    fun getStr(minc:Int,maxc: Int) : String {
        var str = ""
        val nrc = Random.nextInt(minc,maxc)
        repeat(nrc) {
            str += Random.nextInt(65,90).toChar()
        }
        return str
    }

    fun onPriceHistory(view: View) {
        var price_list = arrayListOf<String>()
        var priceAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, price_list)
        var dialog = AlertDialog.Builder(this).setAdapter(priceAdapter, null).setTitle("Price History")
            .setNegativeButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            }).create().show()
    }

    fun onAddCategory(view: View) {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog, null)
        val dialog = AlertDialog.Builder(this).setTitle("New Category").setView(view)
            .setPositiveButton("Create", DialogInterface.OnClickListener { dialog, which ->
                var editText = view.findViewById<EditText>(R.id.editText)
                data.categoryList.add(editText.text.toString())
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            .create().show()
    }

    fun onAddUnit(view: View) {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog, null)
        val dialog = AlertDialog.Builder(this).setTitle("New Category").setView(view)
            .setPositiveButton("Create", DialogInterface.OnClickListener { dialog, which ->
                var editText = view.findViewById<EditText>(R.id.editText)
                data.unitList.add(editText.text.toString())
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            .create().show()
    }

    fun onCreateProduct(view: View) {
        val intent = Intent(this, ListItemsActivity::class.java)
        intent.putExtra("listName", "Continente")
        startActivity(intent)
    }
}