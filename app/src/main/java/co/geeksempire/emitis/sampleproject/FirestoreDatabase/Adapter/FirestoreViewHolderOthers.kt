package co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter

import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageOthersBinding

class FirestoreViewHolderOthers (itemFirestoreMessageBinding: ItemFirestoreMessageOthersBinding) : RecyclerView.ViewHolder(itemFirestoreMessageBinding.root) {
    val rootItemView = itemFirestoreMessageBinding.rootItemView

    val userImageView = itemFirestoreMessageBinding.userImageView
    val userMessageTextView = itemFirestoreMessageBinding.userMessageTextView
}