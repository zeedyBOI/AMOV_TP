package pt.isec.amov_tp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_create_new_list.*
import pt.isec.amov_tp.data.Data
import pt.isec.amov_tp.data.Product
import kotlin.random.Random

class CreateNewItem : AppCompatActivity() {
    var data = Data(arrayListOf(), arrayListOf(), arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_item)
        for (i in 1..20)
            data.productsList.add(Product(description= getStr(5,10), priceHistory = arrayListOf(5.00, 10.00), notes = "", category = "Drinks", srcimg = ""))
        var list = arrayListOf<String>()
        list.add("No Template")
        for (x in data.shopList)
            list.add(x.name)
        var dataAdapter = ArrayAdapter<String>(this, R.layout.spinner_item, list)
        spinner_lists.adapter = dataAdapter
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