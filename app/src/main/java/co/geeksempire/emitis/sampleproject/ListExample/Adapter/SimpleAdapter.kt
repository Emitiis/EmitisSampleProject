package co.geeksempire.emitis.sampleproject.ListExample.Adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.databinding.ItemDataLayoutBinding

class SimpleAdapter (private val context: AppCompatActivity) : RecyclerView.Adapter<ItemDataViewHolder>() {

    //Input List For RecyclerView.Adapter
    val simpleListData: ArrayList<String> = ArrayList<String>()

    override fun getItemCount() : Int {

        return simpleListData.size
    }

    //Set Layout For Adapter - UI
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) : ItemDataViewHolder {

        return ItemDataViewHolder(ItemDataLayoutBinding.inflate(context.layoutInflater, viewGroup, false))
    }

    //All Actions & Process On Items Of A List Occur Here
    override fun onBindViewHolder(itemDataViewHolder: ItemDataViewHolder, position: Int) {

        //Set Data To Each Item
        itemDataViewHolder.itemTextView.text = simpleListData[position] // 1 - 2 - 3 - 4 - 5 --- 99

        if (simpleListData[position].toInt() % 2 == 0) {

            itemDataViewHolder.secondItemTextView.text = "Even"

        } else {

            itemDataViewHolder.secondItemTextView.text = "Odd"

        }

        itemDataViewHolder.itemTextView.setOnClickListener {

            Toast.makeText(context, simpleListData[position], Toast.LENGTH_LONG).show()

            itemDataViewHolder.clickForFun.backgroundTintList = ColorStateList.valueOf(Color.YELLOW)
        }

    }

}