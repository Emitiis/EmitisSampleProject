package co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter

import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageBinding

class FirestoreViewHolder (itemFirestoreMessageBinding: ItemFirestoreMessageBinding) : RecyclerView.ViewHolder(itemFirestoreMessageBinding.root) {
    val userImageView = itemFirestoreMessageBinding.userImageView
    val userMessageTextView = itemFirestoreMessageBinding.userMessageTextView
}