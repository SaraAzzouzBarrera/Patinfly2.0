package cat.urv.deim.asm.patinfly.views.scooters
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.scooters.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.views.scooters.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.views.scooters.repository.ScooterRepository
import kotlinx.coroutines.*
import java.util.*

class ScootersListActivity : AppCompatActivity() {

    private lateinit var scooterRecyclerViewAdapter: ScooterRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooters_list)
        val recyclerView: RecyclerView = findViewById(R.id.scooter_recycler_view)
        scooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(emptyList())
        recyclerView.adapter = scooterRecyclerViewAdapter


        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

        scooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(emptyList())
        recyclerView.adapter = scooterRecyclerViewAdapter

        recyclerView.setHasFixedSize(true)

        val db: AppDatabase = AppDatabase.getInstance(this)
        val scooterDao: ScooterDao = db.scooterDao()

        // Consulta simple
        databaseGetAllWithCoroutines(this, scooterDao)
    }

    private fun databaseGetAllWithCoroutines(context: Context, scooterDao: ScooterDao) {
        CoroutineScope(Dispatchers.Default).launch {
            val scooters: Deferred<List<Scooter>> =
                ScooterRepository.getAllScooters(context, scooterDao)

            withContext(Dispatchers.Main) {
                scooterRecyclerViewAdapter.updateScooters(scooters.await())
            }
        }
    }
}
