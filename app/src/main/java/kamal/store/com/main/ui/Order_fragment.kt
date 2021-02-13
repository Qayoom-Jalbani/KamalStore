package kamal.store.com.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kamal.store.com.R
import kamal.store.com.adapters.Order_Adapter
import kamal.store.com.adapters.Product_Adapter

class Order_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root : View = inflater.inflate(R.layout.fragment_orders, container,false)
        val AddCart: Button = root.findViewById(R.id.add_to_cart)
        AddCart.setOnClickListener{T->
            Navigation.findNavController(root).navigate(R.id.order_to_store)
        }


        val layout_manager: LinearLayoutManager = LinearLayoutManager(requireContext())
        val Product_recycler : RecyclerView = root.findViewById(R.id.order_list)
        val Order_adapter = Order_Adapter()
        Product_recycler.adapter = Order_adapter
        Product_recycler.layoutManager = layout_manager


        return root
    }
}