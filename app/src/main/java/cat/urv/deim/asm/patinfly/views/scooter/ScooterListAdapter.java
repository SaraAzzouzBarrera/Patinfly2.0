package cat.urv.deim.asm.patinfly.views.scooter;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import cat.urv.deim.asm.patinfly.R;

class ScooterListAdapter(private val scooterList,: List<Scooter>) :
        RecyclerView.Adapter<ScooterListAdapter.ScooterViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScooterViewHolder {
        val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_scooter, parent, false)
        return ScooterViewHolder(view)
        }

        override fun onBindViewHolder(holder: ScooterViewHolder, position: Int) {
        val scooter = scooterList[position]
        holder.bind(scooter)
        }

        override fun getItemCount(): Int {
        return scooterList.size
        }

        inner class ScooterViewHolder(itemView:View){ : RecyclerView.ViewHolder(itemView) {
private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
private val textViewBatteryLevel: TextView = itemView.findViewById(R.id.textViewBatteryLevel)

        fun bind(scooter: Scooter) {
        textViewName.text = scooter.name
        textViewBatteryLevel.text = "Battery Level: ${scooter.batteryLevel}";
        }
        }
        }