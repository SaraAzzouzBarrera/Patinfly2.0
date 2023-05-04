package cat.urv.deim.asm.patinfly.views.userinterface

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.databinding.ScootersLlogatsBinding
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
import cat.urv.deim.asm.patinfly.views.scooters.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.patinfly.views.scooters.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.views.scooters.repository.ScooterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class ScootersLlogats : Fragment() {

    private var _binding: ScootersLlogatsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ScootersLlogatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()

        val recyclerView: RecyclerView = binding.scooterRecyclerView
        var scooterList: List<Scooter> = LinkedList<Scooter>()
        val scooterRecyclerViewAdapter: ScooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(scooterList)
        binding.scooterRecyclerView.adapter = scooterRecyclerViewAdapter

        binding.scooterRecyclerView.setHasFixedSize(true)

        val db = AppDatabase.getInstance(requireContext().applicationContext)
        val scooterDao = db.scooterDao()

        val layoutManager = LinearLayoutManager(requireContext().applicationContext)
        binding.scooterRecyclerView.setLayoutManager(layoutManager)

        databaseUpdateRecyclerViewWithCoroutines(requireContext().applicationContext, scooterDao,scooterRecyclerViewAdapter)

    }

    fun databaseUpdateRecyclerViewWithCoroutines(context: Context, scooterDao: ScooterDao, adapter: ScooterRecyclerViewAdapter) {
        CoroutineScope(Dispatchers.Main).launch {
            val scooterDeferred: Deferred<List<Scooter>> =
                ScooterRepository.getScootersLlogats(context, scooterDao,"true")
            val scooters: List<Scooter> = scooterDeferred.await()
            if (scooters.isEmpty()) {
                Log.d(
                    "CoroutineScope",
                    "DB empty" //En el caso que nuestra base de datos no este inicializada en el splash (o en la clase que fuese, en nuestro caso es el splash)
                )                   //nos saldria este mesnaje conforme la base de datos esta vacia y no se nos mostraria nada en el contenido del RecyclerView
            } else {
                Toast.makeText(
                    context,
                    "The number of scooters is: %s".format(scooters.size), //este comentario nos indica la cantidad de scooters que hay en el historial, y el numero del patinete al cual clicamos
                    Toast.LENGTH_LONG
                ).show()
                adapter.updateScooter(scooters)
            }
        }
    }
}