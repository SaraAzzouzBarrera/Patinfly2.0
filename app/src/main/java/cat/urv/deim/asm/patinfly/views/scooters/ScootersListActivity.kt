package cat.urv.deim.asm.patinfly.views.scooters
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.scooters.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.views.scooters.repository.ScooterRepository
import java.util.concurrent.Executors

class ScootersListActivity : AppCompatActivity() {

    private lateinit var scootersAdapter: ScooterRecyclerViewAdapter
    private lateinit var scooters: Scooters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooters_list)



        //val scooterList = ScooterRepository.activeScootersList(this, "scooter.json")
        val recyclerView = findViewById<RecyclerView>(R.id.scooter_recycler_view)
        //val scooters = Scooters(scooterList)
        scootersAdapter = ScooterRecyclerViewAdapter(Scooters())
        recyclerView.adapter = scootersAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        Executors.newSingleThreadExecutor().execute(Runnable {
            scooters = ScootersRepository.getAll()
            scootersAdapter.updateScooters(scooters)

        })


    }

    override fun onResume() {
        super.onResume()

    }
    /* private lateinit var binding: ActivityScootersListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MVC
        //setContentView(R.layout.activity_main)

        //Binding MVVM o MVP
        binding = ActivityScootersListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onResume() {
        super.onResume()

        //val scooters:Scooters  = ScooterRepository.activeScooters()

        //Scooters from json file. To access to the file raw/scooters.json:
        val scooters:Scooters  = ScooterRepository.activeScooters(this,
            AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE)

        // Increase performance when the size is static
        binding.scooterRecyclerView.setHasFixedSize(true)


        // Our RecyclerView is using the linear layout manager
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.scooterRecyclerView.setLayoutManager(layoutManager)

        val adapter:ScooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(scooters)
        binding.scooterRecyclerView.adapter = adapter
    }*/
}

