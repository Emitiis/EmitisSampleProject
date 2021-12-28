package co.geeksempire.emitis.sampleproject.ListOfContacts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.geeksempire.emitis.sampleproject.ListOfContacts.Adapter.SimpleAdapter
import co.geeksempire.emitis.sampleproject.ListOfContacts.DataStructure.DataHolder
import co.geeksempire.emitis.sampleproject.R
import co.geeksempire.emitis.sampleproject.databinding.ListDataLayoutBinding
import kotlinx.coroutines.*

class ListOfDataActivity : AppCompatActivity() {

    val simpleListData: ArrayList<DataHolder/*Type Of Each Item In The List*/> = ArrayList<DataHolder>()

    //RecyclerView Always Needs A LayoutManager & Adapter
    val simpleAdapter: SimpleAdapter by lazy {
        SimpleAdapter(this@ListOfDataActivity)
    }

    lateinit var listDataLayoutBinding: ListDataLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listDataLayoutBinding = ListDataLayoutBinding.inflate(layoutInflater)
        setContentView(listDataLayoutBinding.root)

        listDataLayoutBinding.dataRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        listDataLayoutBinding.dataRecyclerView.adapter = simpleAdapter

        prepareData().invokeOnCompletion {// IO Layer -> Only for Input/Output of Data & Can NOT Access Any Views in Layout

            // Switch From IO Layer To Main Layer Because Of Modifying Views
            CoroutineScope(Dispatchers.Main).launch {// Main Layer -> Can Access Views in Layout

                simpleAdapter.notifyDataSetChanged()

                listDataLayoutBinding.dataRecyclerView.visibility = View.VISIBLE
                listDataLayoutBinding.waitingView.visibility = View.INVISIBLE

            }

        }

    }

    fun prepareData() = CoroutineScope(Dispatchers.IO).async {// 3 Or More Minutes Delay

        delay(3333)// Just As Example
        delay(777)// Just As Example
        delay(555)// Just As Example

        //Adding Data To List
        val dataHolder1 = DataHolder (userName = "Kevin", userAge = 373, userImage = getDrawable(R.drawable.minions))
        val dataHolder2 = DataHolder (userName = "Bob", userAge = 13, userImage = getDrawable(R.drawable.minions))
        val dataHolder3 = DataHolder (userName = "Stewart", userAge = 73, userImage = getDrawable(R.drawable.minions))
        val dataHolder4 = DataHolder (userName = "Sauron", userAge = 3, userImage = getDrawable(R.drawable.minions))
        val dataHolder5 = DataHolder (userName = "Frodo", userAge = 99, userImage = getDrawable(R.drawable.minions))
        val dataHolder6 = DataHolder (userName = "Devil", userAge = 1111, userImage = getDrawable(R.drawable.minions))
        val dataHolder7 = DataHolder (userName = "Elias", userAge = 173, userImage = getDrawable(R.drawable.minions))

        simpleListData.add(dataHolder1)
        simpleListData.add(dataHolder2)
        simpleListData.add(dataHolder3)
        simpleListData.add(dataHolder4)
        simpleListData.add(dataHolder5)
        simpleListData.add(dataHolder6)
        simpleListData.add(dataHolder7)


        simpleAdapter.inputSimpleListData.addAll(simpleListData)

    }

    suspend fun prepareDataAsSuspend() {

    }

}