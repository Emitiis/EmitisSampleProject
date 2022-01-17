package co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.FirestoreDatabase.MessageDataStructure
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageBinding
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageOthersBinding
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirestoreAdapter (private val context: AppCompatActivity, firestoreRecyclerOptions: FirestoreRecyclerOptions<MessageDataStructure>) : FirestoreRecyclerAdapter<MessageDataStructure, RecyclerView.ViewHolder>(firestoreRecyclerOptions) {

    val inputSimpleListData: ArrayList<MessageDataStructure> = ArrayList<MessageDataStructure>()

    val MyselfLayoutType = 1
    val FriendLayoutType = 2

    override fun getItemCount(): Int {

        return inputSimpleListData.size
    }

    override fun getItemViewType(position: Int): Int /* Return An Integer To Define Types Of Views */ {
        super.getItemViewType(position)

        val firebaseUserId = inputSimpleListData[position].userId

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

    override fun onBindViewHolder(genericViewHolder: RecyclerView.ViewHolder, position: Int, messageDataStructure: MessageDataStructure) {

        println(">>>>>>>>>>>>>>>>> " + messageDataStructure.messageContent)

        val firebaseUserId = messageDataStructure.userId

        if (firebaseUserId == Firebase.auth.currentUser!!.uid) {
            //Myself

            val initialViewHolder = (genericViewHolder as FirestoreViewHolder)

            initialViewHolder.userMessageTextView.text = messageDataStructure.messageContent

        } else {
            //Other

            val initialViewHolder = (genericViewHolder as FirestoreViewHolderOthers)

            initialViewHolder.userMessageTextView.text = messageDataStructure.messageContent

        }

    }

}