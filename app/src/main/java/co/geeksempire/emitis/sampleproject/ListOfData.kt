package co.geeksempire.emitis.sampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.geeksempire.emitis.sampleproject.databinding.ListDataLayoutBinding

class ListOfData : AppCompatActivity() {

    lateinit var listDataLayoutBinding: ListDataLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listDataLayoutBinding = ListDataLayoutBinding.inflate(layoutInflater)
        setContentView(listDataLayoutBinding.root)
    }

}