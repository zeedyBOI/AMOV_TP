package pt.isec.amov_tp

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import pt.isec.amov_tp.data.*
import java.io.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), RVAdapterList.OnItemClickListener, RVAdapterList.OnCheckedChangeListener {
    var data : Data = Data(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data.startData()
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

    fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 1234)
        }
    }


    fun onAddNewList(view: View?) {
        val intent = Intent(this, CreateNewListActivity::class.java)
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