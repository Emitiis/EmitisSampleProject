package co.geeksempire.emitis.sampleproject.ListExample.Adapter

import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.databinding.ItemDataLayoutBinding
import com.google.android.material.button.MaterialButton

class ItemDataViewHolder (itemDataLayoutBinding: ItemDataLayoutBinding) : RecyclerView.ViewHolder(itemDataLayoutBinding.root) {
    val itemTextView = itemDataLayoutBinding.itemTextView
    val secondItemTextView = itemDataLayoutBinding.secondItemTextView

    val clickForFun: MaterialButton = itemDataLayoutBinding.clickForFun
}