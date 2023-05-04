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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class ScootersListActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityScootersListBinding
    private lateinit var scooters: Scooters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooters_list)

    }

    override fun onStart() {
        super.onStart()

        val recyclerView: RecyclerView = this.findViewById(R.id.scooter_recycler_view)
        val scooters: List<Scooter> = LinkedList()
        val scooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(scooters)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = scooterRecyclerViewAdapter

        recyclerView.setHasFixedSize(true)

        val db: AppDatabase = AppDatabase.getInstance(this)

        val scooterDao: ScooterDao = db.scooterDao()

        //Consulta simple
        databaseGetAllWithCoroutines(this, scooterDao)

        //Operacions consecutives (wait)
        //databaseCleanInsertAndQueryWithCoroutines(this, scooterDao)

        //Actualització de l'adapter del RecyclerView
        //databaseUpdateRecyclerViewWithCoroutines(this, scooterDao, scooterRecyclerViewAdapter)
    }

    private fun databaseGetAllWithCoroutines(context: Context, scooterDao: ScooterDao) {
        CoroutineScope(Dispatchers.Default).launch {
            val scooters: Deferred<List<Scooter>> =
                ScooterRepository.getAllScooters(context, scooterDao)
            for (scooter in scooters.await()) {
                Log.d(
                    "CoroutineScope",
                    "Scooter: (%d) %s %s".format(
                        scooter.uuid,
                        scooter.name,
                        scooter.longitude,
                        scooter.latitude,
                        scooter.batteryLevel,
                        scooter.kmUse,
                        scooter.dateLastMaintenance,
                        scooter.state,
                        scooter.onRent
                    )
                )
            }
        }
    }

    /*private fun databaseUpdateRecyclerViewWithCoroutines(context: Context, scooterDao: ScooterDao, adapter: ScooterRecyclerViewAdapter){
        CoroutineScope(Dispatchers.Main).launch {
            //Esborrem i insertem les dades novament però no es necessari fer-ho
            // si a la nostra base de dades les dades són correctes

            //A l'exemple esborrem les dades per assegurar-nos que les dades estan abans de
            //mostrar-les a l'adapter
            val deleteResult: Deferred<Unit> = ScooterRepository.deleteAllScooters(context, scooterDao)
            deleteResult.await()
            val insertResult: Deferred<Any> = ScooterRepository.insertScooters(scooterDao, context, scooters.scooters)
            insertResult.await()
            val scootersDeferred: Deferred<List<Scooter>> = ScooterRepository.getAllScooters(context, scooterDao)
            val scooters: List<Scooter> = scootersDeferred.await()
            if (scooters.isEmpty()){
                Log.d(
                    "CoroutineScope",
                    "databaseUpdateRecyclerViewWithCoroutines: La base de dades està buida"
                )
            }
            else{
                Toast.makeText(context, "The number user is: %s".format(scooters.size), Toast.LENGTH_LONG).show()
                adapter.updateScooters(scooters)
            }
        }*/
    }

