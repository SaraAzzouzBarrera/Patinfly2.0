package cat.urv.deim.asm.patinfly.views.scooter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.adapters.ScooterRecyclerViewAdapter

class ScootersListActivity : AppCompatActivity() {

    private lateinit var scootersAdapter: ScooterRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooters_list)

        // Cargar la lista de scooters activos desde el archivo JSON
        val scooterList = ScooterRepository.activeScootersList(this, "scooter.json")

        // Configurar el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.scooter_recycler_view)
        val scooters = Scooters(scooterList)
        scootersAdapter = ScooterRecyclerViewAdapter(scooters)
        recyclerView.adapter = scootersAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

