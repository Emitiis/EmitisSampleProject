package co.geeksempire.emitis.sampleproject.ListOfContacts.Adapter

import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.databinding.ItemDataLayoutBinding

class ItemDataViewHolder (itemDataLayoutBinding: ItemDataLayoutBinding) : RecyclerView.ViewHolder(itemDataLayoutBinding.root) {
    val rootItemView = itemDataLayoutBinding.root

    val userNameTextView = itemDataLayoutBinding.userNameTextView
    val userAgeTextView = itemDataLayoutBinding.userAgeTextView

    val userImageView = itemDataLayoutBinding.userImageView
}