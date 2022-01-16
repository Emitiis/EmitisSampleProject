package co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageBinding
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageOthersBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.ktx.Firebase

class FirestoreAdapter (private val context: AppCompatActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val inputSimpleListData: ArrayList<DocumentSnapshot> = ArrayList<DocumentSnapshot>()

    val MyselfLayoutType = 1
    val FriendLayoutType = 2

    override fun getItemCount(): Int {

        return inputSimpleListData.size
    }

    override fun getItemViewType(position: Int): Int /* Return An Integer To Define Types Of Views */ {
        super.getItemViewType(position)

        val firebaseUserId = inputSimpleListData[position].get("userId")

        return if (firebaseUserId == Firebase.auth.currentUser!!.uid) {
            //Myself

            MyselfLayoutType

        } else {
            //Others

            FriendLayoutType

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == MyselfLayoutType) {// 1 == //viewType -> Our Messages

            FirestoreViewHolder(ItemFirestoreMessageBinding.inflate(context.layoutInflater, viewGroup, false))

        } else if (viewType == FriendLayoutType) {// 2 == //viewType -> Others Messages

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

            initialViewHolder.userMessageTextView.text = inputSimpleListData[position].get("messageContent").toString()

        } else {
            //Other

            val initialViewHolder = (genericViewHolder as FirestoreViewHolderOthers)

            initialViewHolder.userMessageTextView.text = inputSimpleListData[position].get("messageContent").toString()

        }

    }

}