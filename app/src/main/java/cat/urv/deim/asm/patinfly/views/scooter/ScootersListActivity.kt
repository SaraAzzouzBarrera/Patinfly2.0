package cat.urv.deim.asm.patinfly.views.scooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.databinding.ActivityScootersListBinding
import cat.urv.deim.asm.patinfly.views.adapters.ScooterRecyclerViewAdapter

class ScootersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScootersListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scootersConBateria = scooters.filter { it.bateria > 0.0 }
        scootersConBateria.forEach { println("${it.nombre}: ${it.bateria}") }
        val scooter= ScooterRepository.activeScooters()
        ScooterRepository.activeScooterList()

        if (scooter != null) {
            findViewById<TextView>(R.id.scooterNameTextView).text = scooter.name
            findViewById<TextView>(R.id.scooterBatteryTextView).text = scooter.batteryLevel
            ScooterRepository.activeScooterList(scooter)
        }

        // Binding MVVM o MVP
        binding = ActivityScootersListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Increase performance when the size is static
        binding.scooterRecyclerView.setHasFixedSize(true)

        // Our RecyclerView is using the linear layout manager
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.scooterRecyclerView.setLayoutManager(layoutManager)

        // Get the list of active scooters from the repository
        val scooters = ScooterRepository.activeScooters()

        // Set the adapter to the RecyclerView
        val adapter = ScooterRecyclerViewAdapter(scooters)
        binding.scooterRecyclerView.adapter = adapter
    }
}
