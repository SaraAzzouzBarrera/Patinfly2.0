package cat.urv.deim.asm.patinfly.views.scooters
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.scooters.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.views.scooters.repository.ScooterRepository

class ScootersListActivity : AppCompatActivity() {

    private lateinit var scootersAdapter: ScooterRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooters_list)

        val scooterList = ScooterRepository.activeScootersList(this, "scooter.json")
        val recyclerView = findViewById<RecyclerView>(R.id.scooter_recycler_view)
        val scooters = Scooters(scooterList)
        scootersAdapter = ScooterRecyclerViewAdapter(scooters)
        recyclerView.adapter = scootersAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

