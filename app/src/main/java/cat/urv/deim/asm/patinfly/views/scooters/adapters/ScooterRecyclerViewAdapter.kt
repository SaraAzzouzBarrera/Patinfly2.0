package cat.urv.deim.asm.patinfly.views.scooters.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.Scooters

class ScooterRecyclerViewAdapter(private var scooters: List<Scooter>) : RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>()  {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val root: View

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            root = view
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateScooters(scooters: List<Scooter>) {
        this.scooters = scooters
        notifyDataSetChanged()
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.scooter_item_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = scooters.get(position).uuid
        viewHolder.root.setOnClickListener {
            Toast.makeText(viewHolder.root.context,
                "Row selected %d".format(position),
                Toast.LENGTH_LONG).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = scooters.size

   @SuppressLint("NotifyDataSetChanged")
    fun updateScooters(scooters: Scooters) {
        this.scooters = scooters.scooters
        Log.d("UserRecyclerViewAdapter", "number of scooters %s".format(this.scooters))
        this.notifyDataSetChanged()
    }
    fun updateScooter(scooters: List<Scooter>) {
        this.scooters = scooters
        this.notifyDataSetChanged()
    }
}