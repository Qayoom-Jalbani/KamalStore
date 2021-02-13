package kamal.store.com.main.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kamal.store.com.R
import kamal.store.com.adapters.Product_Adapter


class Store_fragment : Fragment() {

    lateinit var M_Tinctures: Button
    lateinit var Potencies: Button
    lateinit var Bio_chemics: Button
    lateinit var Compounds: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_store, container, false)

        val itemDvider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        itemDvider.setDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.item_divider
            )!!
        )

        val layout_manager: GridLayoutManager = GridLayoutManager(requireContext(), 2)
        val Product_recycler: RecyclerView = root.findViewById(R.id.Product_Recycler)
        val Product_adapter = Product_Adapter()
        Product_recycler.adapter = Product_adapter
        Product_recycler.addItemDecoration(itemDvider)
        Product_recycler.layoutManager = layout_manager

        M_Tinctures = root.findViewById(R.id.m_Tinctures)
        Potencies = root.findViewById(R.id.potencies)
        Bio_chemics = root.findViewById(R.id.bio_chemics)
        Compounds = root.findViewById(R.id.compounds)

        M_Tinctures.setOnClickListener(category)
        Potencies.setOnClickListener(category)
        Bio_chemics.setOnClickListener(category)
        Compounds.setOnClickListener(category)


        return root
    }

    val category: View.OnClickListener = View.OnClickListener { T ->
        M_Tinctures.setBackgroundResource(R.drawable.normal_button)
        M_Tinctures.setTextColor(Color.parseColor("#333333"))
        Potencies.setBackgroundResource(R.drawable.normal_button)
        Potencies.setTextColor(Color.parseColor("#333333"))
        Bio_chemics.setBackgroundResource(R.drawable.normal_button)
        Bio_chemics.setTextColor(Color.parseColor("#333333"))
        Compounds.setBackgroundResource(R.drawable.normal_button)
        Compounds.setTextColor(Color.parseColor("#333333"))

        val Clickbtn: Button = T as Button
        Clickbtn.setBackgroundResource(R.drawable.category_selected_button)
        Clickbtn.setTextColor(Color.parseColor("#ffffff"))

    }
}