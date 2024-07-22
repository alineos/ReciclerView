package br.edu.ifsp.dmo.view

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.dmo.R
import br.edu.ifsp.dmo.model.AlgoImportante

class MainActivity : AppCompatActivity() , DeleteClickListener{

    private val dataSource = ArrayList<AlgoImportante>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataSource.add(AlgoImportante())
        dataSource.add(AlgoImportante())
        dataSource.add(AlgoImportante())
        dataSource.add(AlgoImportante())

        findById()
        setupRecyclerView()
        setupListener()

        }

    override fun onDeleteItemClick(position: Int) {
        dataSource.removeAt(position)
        val adapter = recyclerView.adapter
        adapter?.notifyDataSetChanged()
    }

    private fun setupListener(){
        buttonAdd.setOnClickListener{
            val algoImportante = AlgoImportante()
            dataSource.add(algoImportante)

            val adapter = recyclerView.adapter
            adapter?.notifyDataSetChanged()
        }
    }

    private fun setupRecyclerView(){

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        val adapter = AlgoImportanteAdapter(dataSource, this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun findById(){
        recyclerView = findViewById(R.id.recycler_view)
        buttonAdd = findViewById(R.id.button_add)
    }
}