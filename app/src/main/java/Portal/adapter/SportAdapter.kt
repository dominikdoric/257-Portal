package Portal.adapter

import Portal.a257.R
import Portal.database.table.SportTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_sport.view.*

class SportAdapter(): RecyclerView.Adapter<SportAdapter.ViewHolder>() {

    private var sportList = emptyList<SportTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_sport, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportAdapter.ViewHolder, position: Int) {
        val currentItem = sportList[position]
        holder.itemView.textViewSportNaslov.text = currentItem.sportNaslov
        holder.itemView.textViewSportVrijeme.text = currentItem.sportVrijeme
    }

    override fun getItemCount(): Int {
        return sportList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(sport: List<SportTable>){
        this.sportList = sport
        notifyDataSetChanged()
    }

}