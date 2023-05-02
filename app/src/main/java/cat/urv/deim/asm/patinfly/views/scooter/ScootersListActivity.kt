package cat.urv.deim.asm.patinfly.views.scooter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.databinding.ActivityScootersListBinding
import cat.urv.deim.asm.patinfly.views.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.views.persistence.AppConfig

class ScootersListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScootersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooter_detail)

        val scooterList = ScooterRepository.activeScootersList(this, "scooters.json")

        if(scooterList!=null) {
            findViewById<TextView>(R.id.ScooterName).text = scooterList[0].name
            findViewById<TextView>(R.id.batteryLevel).text= scooterList[1].longitude
        }

       //Hay que crear el botton para ver el scooter seleccionado (navigateTo DetailActivity)
    }
}