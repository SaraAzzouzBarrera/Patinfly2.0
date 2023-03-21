package cat.urv.deim.asm.patinfly.views.tutorial;

        import android.view.View
        import android.view.ViewGroup
        import android.widget.ImageView
        import android.widget.TextView
        import android.widget.Toast
        import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var title: List<String>, private var details: List<String>, private var images: List<Int>):RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>(){
        inner class Pager2ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val

        }
