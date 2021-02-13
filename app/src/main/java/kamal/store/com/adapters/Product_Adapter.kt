package kamal.store.com.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kamal.store.com.R
import kamal.store.com.models.Product

class Product_Adapter : RecyclerView.Adapter<Product_Adapter.ViewHolder>() {

    val P_List: ArrayList<Product> = ArrayList<Product>()
    val PName: Array<String> = arrayOf(
        "ABIES NIGRA Ø",
        "HEMLOCK SPRUCE",
        "Black Spruce",
        "Devil’s cotton",
        "Southernwood , lady’s love",
        "Crab’s Eye Vine",
        "Common Wormwood",
        "Indian Nettle",
        "SOAP POD",
        "PRICKLY CHAFF-FLOWER",
        "ACETIC ACID",
        "BENZOIC ACID"
    )
    val pack: Array<String> = arrayOf(
        "150 ML",
        "170 ML",
        "100 ML",
        "50 ML",
        "500 ML",
        "75 ML",
        "100 ML",
        "200 ML",
        "250 ML",
        "250 ML",
        "700 ML",
        "700 ML"
    )
    val Price: Array<Int> = arrayOf(150, 170, 100, 50, 500, 75, 100, 200, 250, 250, 700, 950)
    init {
        AddItem()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Add_to_cart: Button = view.findViewById(R.id.product_add)
        val Name: TextView = view.findViewById(R.id.product_name)
        val Price: TextView = view.findViewById(R.id.product_price)
        val PackSize: TextView = view.findViewById(R.id.product_packSize)

        init {
            Add_to_cart.setOnClickListener { v ->
                val bundle: Bundle = Bundle()
                val Item: Product = P_List.get(adapterPosition)
                bundle.putParcelable("item",Item)
                Navigation.findNavController(view).navigate(R.id.store_to_product_detail,bundle)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_type, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val Item:Product = P_List.get(position)
        holder.Name.text = Item.Product_Name
        holder.Price.text = Item.Product_Price.toString()
        holder.PackSize.text = Item.Product_power
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return P_List.size
    }



    fun AddItem() {
        P_List.clear()
        for (i in 0..PName.size-1) {
            val Item: Product = Product()
            Item.Product_Name = PName[i]
            Item.Product_id = i.toString()
            Item.Product_Qty = 1
            Item.Product_power = pack[i]
            Item.Product_Price = Price[i]
            Item.Product_Des =
                "This drug produces a condition of profound anæmia, with some dropsical symptoms, great debility, frequent fainting, dyspnœa, weak heart, vomiting, profuse urination and sweat. Hæmorrhage from any part. Especially indicated in pale, lean persons, with lax, flabby muscles. Wasting and debility. Acetic acid has the power to liquefy albuminous and fibrinous deposits. Epithelial cancer, internally and locally (W Owens). Sycosis with nodules and formations in the joints. Hard chancre. The 1x soluti"

            P_List.add(Item)
        }
    }
}
