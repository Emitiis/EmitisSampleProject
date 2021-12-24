package co.geeksempire.emitis.sampleproject.ListExample.Adapter

import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.databinding.ItemDataLayoutBinding

class ItemDataViewHolder (itemDataLayoutBinding: ItemDataLayoutBinding) : RecyclerView.ViewHolder(itemDataLayoutBinding.root) {
    val itemTextView = itemDataLayoutBinding.itemTextView
    val secondItemTextView = itemDataLayoutBinding.secondItemTextView
}