package pt.isec.amov_tp

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import pt.isec.amov_tp.data.Data

class ListItemsActivity : AppCompatActivity() {
    lateinit var data : Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_items)
        setSupportActionBar(findViewById(R.id.toolbar))
        data = intent.getSerializableExtra("data") as Data
        var listName = intent.getStringExtra("listName")
        findViewById<FloatingActionButton>(R.id.fab_addList).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    fun onAddNewItem(view: View?) {
        val items = data.itemsList.map { it -> it.toStringSmall() }.sorted().toTypedArray()
        AlertDialog.Builder(this).setTitle("New Item").setIcon(android.R.drawable.ic_menu_add)
                .setSingleChoiceItems(items, 0, DialogInterface.OnClickListener{ dialog, which ->
                    Toast.makeText(this,"Item: $which", Toast.LENGTH_LONG).show()
                })
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this,"" + "Ok", Toast.LENGTH_LONG).show()
                })
                .setNeutralButton("Create New Item", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "Create New Item", Toast.LENGTH_LONG).show()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this,"" + "Cancel", Toast.LENGTH_LONG).show()
                })
                .setCancelable(true)
                .create()
                .show()
    }
}