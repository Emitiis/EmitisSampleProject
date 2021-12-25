package co.geeksempire.emitis.sampleproject.ListExample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.geeksempire.emitis.sampleproject.ListExample.Adapter.SimpleAdapter
import co.geeksempire.emitis.sampleproject.databinding.ListDataLayoutBinding

class ListOfDataActivity : AppCompatActivity() {

    val simpleListData: ArrayList<String/*Type Of Each Item In The List*/> = ArrayList<String>()

    lateinit var listDataLayoutBinding: ListDataLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listDataLayoutBinding = ListDataLayoutBinding.inflate(layoutInflater)
        setContentView(listDataLayoutBinding.root)

        //Adding Data To List
        (1..99).forEach { number ->

            simpleListData.add(number.toString())

        }

        //RecyclerView Always Needs A LayoutManager & Adapter
        val simpleAdapter = SimpleAdapter(this@ListOfDataActivity)

        listDataLayoutBinding.dataRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        listDataLayoutBinding.dataRecyclerView.adapter = simpleAdapter

        simpleAdapter.inputSimpleListData.addAll(simpleListData)

        simpleAdapter.notifyDataSetChanged()

    }

}