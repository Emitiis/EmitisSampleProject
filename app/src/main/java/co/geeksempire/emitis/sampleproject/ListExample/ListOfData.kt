package co.geeksempire.emitis.sampleproject.ListExample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.geeksempire.emitis.sampleproject.databinding.ListDataLayoutBinding

class ListOfData : AppCompatActivity() {

    val simpleListData: ArrayList<String> = ArrayList<String>()

    lateinit var listDataLayoutBinding: ListDataLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listDataLayoutBinding = ListDataLayoutBinding.inflate(layoutInflater)
        setContentView(listDataLayoutBinding.root)

        (1..99).forEach { number ->

            simpleListData.add(number.toString())

        }

        listDataLayoutBinding.dataRecyclerView.layoutManager = LinearLayoutManager(applicationContext)


    }

}