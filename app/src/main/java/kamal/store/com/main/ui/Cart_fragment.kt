package kamal.store.com.main.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kamal.store.com.R
import kamal.store.com.adapters.Cart_Adapter
import kamal.store.com.adapters.Cart_Adapter.onDelete
import kamal.store.com.models.cartList

class Cart_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_cart, container, false)

        val AddCart:Button = root.findViewById(R.id.add_to_cart)
        AddCart.setOnClickListener{T->
            Navigation.findNavController(root).navigate(R.id.cart_to_store)
        }
        val itemDvider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        itemDvider.setDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.item_divider
            )!!
        )
        val EmptyView: ConstraintLayout = root.findViewById(R.id.empty_view)

        val layout_manager: LinearLayoutManager = LinearLayoutManager(requireContext())
        val cart_recycler: RecyclerView = root.findViewById(R.id.cart_recycler)
        val Cart_adapter = Cart_Adapter()


        cart_recycler.adapter = Cart_adapter
        cart_recycler.addItemDecoration(itemDvider)
        cart_recycler.layoutManager = layout_manager
        Cart_adapter.Additem()

        if (cartList.size > 0) {
            EmptyView.visibility = View.GONE
            cart_recycler.visibility = View.VISIBLE
        } else {
            EmptyView.visibility = View.VISIBLE
            cart_recycler.visibility = View.INVISIBLE
        }

        val CheckOut: Button = root.findViewById(R.id.check_out)
        CheckOut.setOnClickListener { T->
            Navigation.findNavController(T).navigate(R.id.cart_to_place_order)
        }

        val onItemDelete = object: onDelete{
            override fun onDeleteItem(){

                if (cartList.size > 0) {
                    EmptyView.visibility = View.GONE
                    cart_recycler.visibility = View.VISIBLE
                } else {
                    EmptyView.visibility = View.VISIBLE
                    cart_recycler.visibility = View.INVISIBLE
                }
            }
        }
        Cart_adapter.setInterface(onItemDelete)


        return root
    }
}