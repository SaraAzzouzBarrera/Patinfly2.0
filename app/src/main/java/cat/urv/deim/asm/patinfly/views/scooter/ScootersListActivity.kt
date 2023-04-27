package cat.urv.deim.asm.patinfly.views.scooter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.databinding.ActivityScootersListBinding
import cat.urv.deim.asm.patinfly.views.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.views.base.AppConfig

class ScootersListActivity : AppCompatActivity() {

    //La idea es poner el nombre i la bateria de los scooters activos


    private lateinit var binding: ActivityScootersListBinding

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

        val scooterList = ScooterRepository.activeScootersList(this, "dadescooter.json")

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
    }
}