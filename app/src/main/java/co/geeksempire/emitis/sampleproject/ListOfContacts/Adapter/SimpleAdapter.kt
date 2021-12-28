package co.geeksempire.emitis.sampleproject.ListOfContacts.Adapter

import android.content.Intent
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.Chat.OnlineChatActivity
import co.geeksempire.emitis.sampleproject.ListOfContacts.DataStructure.DataHolder
import co.geeksempire.emitis.sampleproject.databinding.ItemDataLayoutBinding

class SimpleAdapter (private val context: AppCompatActivity) : RecyclerView.Adapter<ItemDataViewHolder>() {

    //Input List For RecyclerView.Adapter
    val inputSimpleListData: ArrayList<DataHolder> = ArrayList<DataHolder>()

    override fun getItemCount() : Int {

        return inputSimpleListData.size
    }

    //Set Layout For Adapter - UI
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) : ItemDataViewHolder {

        return ItemDataViewHolder(ItemDataLayoutBinding.inflate(context.layoutInflater, viewGroup, false))
    }

    //All Actions & Process On Items Of A List Occur Here
    override fun onBindViewHolder(itemDataViewHolder: ItemDataViewHolder, position: Int) {

        //Set Data To Each Item
        itemDataViewHolder.userNameTextView.text = inputSimpleListData[position].userName
        itemDataViewHolder.userAgeTextView.text = inputSimpleListData[position].userAge.toString()
        itemDataViewHolder.userImageView.setImageDrawable(inputSimpleListData[position].userImage)

        itemDataViewHolder.rootItemView.setOnClickListener {

//            Toast.makeText(context, inputSimpleListData[position].userName + " - " + inputSimpleListData[position].userAge, Toast.LENGTH_LONG).show()

            val goToListIntent = Intent(context /* From Source Activity */, OnlineChatActivity::class.java /* To Target Activity */).apply {
                putExtra("USERNAME" /* Key */, inputSimpleListData[position].userName /* Value */)
            }
            goToListIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            context.startActivity(goToListIntent)

        }

    }

}