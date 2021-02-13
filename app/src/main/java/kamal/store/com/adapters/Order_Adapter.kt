package kamal.store.com.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kamal.store.com.R

class Order_Adapter : RecyclerView.Adapter<Order_Adapter.ViewHolder>() {



    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       // TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_item_type, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return 20
    }
}