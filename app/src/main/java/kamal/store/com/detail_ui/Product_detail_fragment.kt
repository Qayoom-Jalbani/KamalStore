package kamal.store.com.detail_ui

import android.app.Notification
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kamal.store.com.R
import kamal.store.com.models.Product
import kamal.store.com.models.cartList

class Product_detail_fragment : Fragment() {

    var Qty: Int = 1
    lateinit var Quntity: EditText
    lateinit var Add_cart: Button

    var finalQty: Int = 0
    var ProductID: String = "0"
    lateinit var item: Product

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_product_detail, container, false)
        val bundle: Bundle? = arguments

        item = bundle?.getParcelable<Product>("item")!!
        ProductID = item?.Product_id.toString()
        val add: ImageView = root.findViewById(R.id.product_add)
        val subtract: ImageView = root.findViewById(R.id.product_sub)
        add.setOnClickListener(setQty)
        subtract.setOnClickListener(setQty)

        Quntity = root.findViewById(R.id.product_qty)


        Add_cart = root.findViewById(R.id.add_cart);
        Add_cart.setOnClickListener { Ti ->
            UpdateQty()
        }
        initialization()
        return root
    }

    fun initialization(){
        for (item in cartList) {
            Log.e("QWE", "P_ID = " + ProductID + " Item P_ID = " + item.Product_id)
            if (ProductID.equals(item.Product_id)) {
                Add_cart.isEnabled = false
                Quntity.setText(item.Product_Qty.toString())
                Qty = Integer.parseInt(item.Product_Qty.toString())
                finalQty = Integer.parseInt(item.Product_Qty.toString())
                break
            }
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
        Quntity.setText(Qty.toString())

        if (finalQty == Qty) {
            Add_cart.isEnabled = false
        } else {
            Add_cart.isEnabled = true
        }
    }

    var isFind: Boolean = false
    fun UpdateQty() {
        isFind = false
        for (item in cartList) {
            Log.e("QWE", "P_ID = " + ProductID + " Item P_ID = " + item.Product_id)
            if (ProductID.equals(item.Product_id)) {
                item.Product_Qty = Integer.parseInt(Quntity.text.toString())
                isFind = true
                Add_cart.isEnabled = false
                break
            }
        }
        if (!isFind) {
            AddItem()
        }
    }


    fun AddItem() {
        item.Product_Qty = Qty
        finalQty = Qty
        cartList.add(item)
        Add_cart.isEnabled = false
    }
}