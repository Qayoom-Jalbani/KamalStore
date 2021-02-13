package kamal.store.com.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.*



class Product() : Parcelable {

    var Product_id: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var Product_Name: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var Product_power: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var Product_Des: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }


    var Product_Price: Int = 0
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var Product_Qty: Int = 1
        get() {
            return field
        }
        set(value) {
            field = value
        }

    constructor(parcel: Parcel) : this() {
    }


    override fun toString(): String {
        return "Product(Product_id='$Product_id', Product_Name='$Product_Name', Product_power='$Product_power', Product_Des='$Product_Des', Product_Price=$Product_Price, Product_Qty=$Product_Qty)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }


}