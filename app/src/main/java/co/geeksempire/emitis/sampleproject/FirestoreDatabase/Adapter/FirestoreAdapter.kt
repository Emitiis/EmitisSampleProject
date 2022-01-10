package co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.R
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageBinding
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageOthersBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.ktx.Firebase

class FirestoreAdapter (private val context: AppCompatActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val inputSimpleListData: ArrayList<DocumentSnapshot> = ArrayList<DocumentSnapshot>()

    override fun getItemCount(): Int {

        return inputSimpleListData.size
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)

        val firebaseUserId = inputSimpleListData[position].get("userId")

        return if (firebaseUserId == Firebase.auth.currentUser!!.uid) {
            //Myself

            1

        } else {
            //Others

            2

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return if (viewType == 1) {// 1 == //viewType -> Our Messages

            FirestoreViewHolder(ItemFirestoreMessageBinding.inflate(context.layoutInflater, viewGroup, false))

        } else if (viewType == 2) {// 2 == //viewType -> Others Messages

            FirestoreViewHolderOthers(ItemFirestoreMessageOthersBinding.inflate(context.layoutInflater, viewGroup, false))

        } else {

            FirestoreViewHolder(ItemFirestoreMessageBinding.inflate(context.layoutInflater, viewGroup, false))

        }
    }

    override fun onBindViewHolder(genericViewHolder: RecyclerView.ViewHolder, position: Int) {

        val firebaseUserId = inputSimpleListData[position].get("userId")

        if (firebaseUserId == Firebase.auth.currentUser!!.uid) {
            //Myself

            val initialViewHolder = (genericViewHolder as FirestoreViewHolder)

            //Background Green
            initialViewHolder.rootItemView.setBackgroundColor(context.getColor(R.color.green))

            initialViewHolder.userMessageTextView.text = inputSimpleListData[position].get("messageContent").toString()

            initialViewHolder.userImageView.visibility = View.VISIBLE

        } else {
            //Other

            val initialViewHolder = (genericViewHolder as FirestoreViewHolderOthers)

            //Background Gray
            initialViewHolder.rootItemView.setBackgroundColor(context.getColor(R.color.design_default_color_primary))

            initialViewHolder.userMessageTextView.text = inputSimpleListData[position].get("messageContent").toString()

            initialViewHolder.userImageView.visibility = View.INVISIBLE

        }

    }

}