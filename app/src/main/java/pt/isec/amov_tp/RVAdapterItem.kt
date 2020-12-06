package pt.isec.amov_tp

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.isec.amov_tp.data.Item

class RVAdapterItem(val data: List<Item>, val listener: OnItemClickListener, val listenerCheck: OnCheckedChangeListener) : RecyclerView.Adapter<RVAdapterItem.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        var item_title : TextView = view.findViewById(R.id.item_name)
        var item_price : TextView = view.findViewById(R.id.item_price)
        var item_check = view.findViewById<CheckBox>(R.id.item_check)
        init {
            view.setOnClickListener(this)
            item_check.setOnCheckedChangeListener(this)
        }
        fun update(str1 : String, str2 : String) {
            item_title.text = str1
            item_price.text = str2
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                listener.onItemClick(position)
        }

        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            if (isChecked) {
                val position = adapterPosition
                listenerCheck.onCheckChanged(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.update(data[position].product.description, "€" + data[position].product.priceHistory.last().toString())
    }

    override fun getItemCount(): Int = data.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnCheckedChangeListener {
        fun onCheckChanged(position: Int)
    }
}