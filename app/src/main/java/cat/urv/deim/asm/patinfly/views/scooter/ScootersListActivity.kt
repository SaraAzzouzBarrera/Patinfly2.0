package cat.urv.deim.asm.patinfly.views.scooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R


class ScooterListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScooterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooter_list)

        recyclerView = findViewById(R.id.recyclerViewScooters)
        adapter = ScooterListAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val scooterRepository = ScooterRepository(ScooterDatabase.getInstance(this).scooterDao())
        val availableScooters = scooterRepository.getAllScooters().filter { it.state == "ACTIVE" }

        adapter.setScooters(availableScooters)
    }
}