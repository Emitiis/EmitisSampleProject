package co.geeksempire.emitis.sampleproject.ListExample.Adapter

import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.databinding.ItemDataLayoutBinding

class SimpleAdapter (private val context: AppCompatActivity) : RecyclerView.Adapter<ItemDataViewHolder>() {

    val simpleListData: ArrayList<String> = ArrayList<String>()

    override fun getItemCount() : Int {

        return simpleListData.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) : ItemDataViewHolder {

        return ItemDataViewHolder(ItemDataLayoutBinding.inflate(context.layoutInflater, viewGroup, false))
    }

    override fun onBindViewHolder(itemDataViewHolder: ItemDataViewHolder, position: Int) {

        //
        //All Actions On Items Of A List Occur Here
        //

        itemDataViewHolder.itemTextView.text = simpleListData[position] // 1 - 2 - 3 - 4 - 5 --- 99

        itemDataViewHolder.itemTextView.setOnClickListener {

            Toast.makeText(context, simpleListData[position], Toast.LENGTH_LONG).show()

        }

    }

}