package pt.isec.amov_tp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.isec.amov_tp.data.Data

class RVAdapterList(val data : Data, val listener: OnItemClickListener, val listenerCheck: OnCheckedChangeListener) : RecyclerView.Adapter<RVAdapterList.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        var list_title : TextView = view.findViewById(R.id.list_name)
        var list_price : TextView = view.findViewById(R.id.list_price)
        var list_check = view.findViewById<CheckBox>(R.id.list_check)
        init {
            view.setOnClickListener(this)
            list_check.setOnCheckedChangeListener(this)
        }
        fun update(str1 : String, str2 : String) {
            list_title.text = str1
            list_price.text = str2
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            if (isChecked) {
                val position = adapterPosition
                listenerCheck.onCheckChanged(position)
            }
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

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnCheckedChangeListener {
        fun onCheckChanged(position: Int)
    }
}