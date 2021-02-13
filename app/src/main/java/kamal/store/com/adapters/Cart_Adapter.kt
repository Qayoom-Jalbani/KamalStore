package kamal.store.com.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kamal.store.com.R
import kamal.store.com.models.Product
import kamal.store.com.models.cartList

class Cart_Adapter : RecyclerView.Adapter<Cart_Adapter.ViewHolder>() {

    public val CartList: ArrayList<Product> = ArrayList()

    var Qty: Int = 1

    fun Additem() {
        CartList.clear()
        CartList.addAll(cartList)
        notifyDataSetChanged()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val Quntity: EditText = view.findViewById(R.id.product_qty)
        val delete: ImageButton = view.findViewById(R.id.delete_item)
        val deletetext: TextView = view.findViewById(R.id.delete_title)

        val Name: TextView = view.findViewById(R.id.product_name)
        val packSize: TextView = view.findViewById(R.id.product_packSize)
        val Price: TextView = view.findViewById(R.id.product_price)

        val add: ImageView = view.findViewById(R.id.product_add)
        val subtract: ImageView = view.findViewById(R.id.product_sub)

        val onDelete: View.OnClickListener = View.OnClickListener { t ->
            CartList.removeAt(adapterPosition)
            notifyDataSetChanged()
            cartList.clear()
            cartList.addAll(CartList)
            if (delete_item != null) {
                delete_item.onDeleteItem()
            }
        }
        val setQty: View.OnClickListener = View.OnClickListener { T ->
            if (T.id == R.id.product_add) {
                Qty++
            } else {
                if (Qty > 1) {
                    Qty--
                }
            }
            cartList.get(adapterPosition).Product_Qty = Qty
            CartList.get(adapterPosition).Product_Qty = Qty
            Quntity.setText(Qty.toString())

        }

        init {
            delete.setOnClickListener(onDelete)
            deletetext.setOnClickListener(onDelete)
            add.setOnClickListener(setQty)
            subtract.setOnClickListener(setQty)
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item_type, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Item: Product = CartList.get(position)
        holder.Name.text = Item.Product_Name
        holder.Price.text = Item.Product_Price.toString()
        holder.packSize.text = Item.Product_power
        holder.Quntity.setText(Item.Product_Qty.toString())
        holder.Name.text = Item.Product_Name
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return CartList.size
    }


    lateinit var delete_item: onDelete
    public fun setInterface(ondelete: onDelete) {
        delete_item = ondelete
    }

    interface onDelete {
        fun onDeleteItem()
    }

}