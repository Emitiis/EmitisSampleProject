package co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.R
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.ktx.Firebase

class FirestoreAdapter (private val context: AppCompatActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val inputSimpleListData: ArrayList<DocumentSnapshot> = ArrayList<DocumentSnapshot>()

    override fun getItemCount(): Int {

        return inputSimpleListData.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FirestoreViewHolder {

//        val firestoreViewHolder = FirestoreViewHolder(ItemFirestoreMessageBinding.inflate(context.layoutInflater, viewGroup, false))
//
//        val firestoreViewHolderOthers = FirestoreViewHolderOthers(ItemFirestoreMessageOthersBinding.inflate(context.layoutInflater, viewGroup, false))

        return FirestoreViewHolder(ItemFirestoreMessageBinding.inflate(context.layoutInflater, viewGroup, false))
    }

//    override fun getItemViewType(position: Int): Int {
//        super.getItemViewType(position)
//
//        return inputSimpleListData[position].get("userId")
//    }

    override fun onBindViewHolder(genericViewHolder: RecyclerView.ViewHolder, position: Int) {

        val firebaseUserId = inputSimpleListData[position].get("userId")

        val initialViewHolder = (genericViewHolder as FirestoreViewHolder)

        if (firebaseUserId == Firebase.auth.currentUser!!.uid) {
            //Myself

            //Background Green
            initialViewHolder.rootItemView.setBackgroundColor(context.getColor(R.color.green))

            initialViewHolder.userMessageTextView.text = inputSimpleListData[position].get("messageContent").toString()

            initialViewHolder.userImageView.visibility = View.VISIBLE
            initialViewHolder.userImageViewOthers.visibility = View.INVISIBLE

        } else {
            //Other

            //Background Gray
            initialViewHolder.rootItemView.setBackgroundColor(context.getColor(R.color.design_default_color_primary))

            initialViewHolder.userMessageTextView.text = inputSimpleListData[position].get("messageContent").toString()

            initialViewHolder.userImageView.visibility = View.INVISIBLE
            initialViewHolder.userImageViewOthers.visibility = View.VISIBLE

        }

    }

}