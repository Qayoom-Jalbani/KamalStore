package kamal.store.com.detail_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import kamal.store.com.R
import kamal.store.com.models.Product
import kamal.store.com.models.cartList

class Checkout_fragment : Fragment() {

    lateinit var Cash: ConstraintLayout;
    lateinit var JazzCash: ConstraintLayout;
    lateinit var EasyPaisa: ConstraintLayout;
    lateinit var Place_Order: Button;

    lateinit var img_cash:ImageView;
    lateinit var img_jazz:ImageView;
    lateinit var img_easy:ImageView;


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_checkout, container, false)

         Cash = root.findViewById(R.id.cash_on_delivery)
         JazzCash = root.findViewById(R.id.jazz_cash)
         EasyPaisa = root.findViewById(R.id.easy_pesa)

         Place_Order = root.findViewById(R.id.place_order)

        img_cash = root.findViewById(R.id.img_cash)
        img_jazz = root.findViewById(R.id.img_jazz)
        img_easy = root.findViewById(R.id.img_easy)

        Cash.setOnClickListener(onClick)
        JazzCash.setOnClickListener(onClick)
        EasyPaisa.setOnClickListener(onClick)

        return root
    }

    val onClick: View.OnClickListener = View.OnClickListener { T ->
        if (T.id == R.id.cash_on_delivery) {
            Place_Order.visibility = View.VISIBLE
            img_cash.visibility = View.VISIBLE
            img_jazz.visibility = View.INVISIBLE
            img_easy.visibility = View.INVISIBLE

        } else if (T.id == R.id.jazz_cash) {
            Place_Order.visibility = View.INVISIBLE
            img_cash.visibility = View.INVISIBLE
            img_jazz.visibility = View.VISIBLE
            img_easy.visibility = View.INVISIBLE

        } else if (T.id == R.id.easy_pesa) {
            Place_Order.visibility = View.INVISIBLE
            img_cash.visibility = View.INVISIBLE
            img_jazz.visibility = View.INVISIBLE
            img_easy.visibility = View.VISIBLE
        }

    }
}