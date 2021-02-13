package kamal.store.com.main.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.database.Cursor
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kamal.store.com.R


class Account_fragment : Fragment() {

    lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_account, container, false)

        imageView = root.findViewById(R.id.img_profile)
        val camer: ImageView = root.findViewById(R.id.img_add)
        camer.setOnClickListener { T ->
            val i = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(i, 100)
        }


        val Gender: AutoCompleteTextView = root.findViewById(R.id.user_gender)
        val items = listOf("Male", "Female")
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_selectable_list_item,
            items
        )
        Gender.setAdapter(adapter)
        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && null != data) {
            val selectedImage: Uri = data.data!!
            imageView.setImageURI(selectedImage)
        }
    }
}