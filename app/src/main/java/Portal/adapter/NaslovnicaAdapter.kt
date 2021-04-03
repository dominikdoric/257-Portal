package Portal.adapter

import Portal.a257.R
import Portal.database.table.SportTable
import Portal.fragmenti.fragmenti.SportFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_sport.view.*

class NaslovnicaAdapter() : RecyclerView.Adapter<NaslovnicaAdapter.ViewHolder>() {

    private var sportList = emptyList<SportTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NaslovnicaAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_sport, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportAdapter.ViewHolder, position: Int) {
        val currentItem = sportList[position]
        holder.itemView.textViewSportNaslov.text = currentItem.sportNaslov
        holder.itemView.textViewSportVrijeme.text = currentItem.sportVrijeme

        holder.itemView.cardViewSport.setOnLongClickListener {
            val action =
                SportFragmentDirections.actionSportNavDrawerToUpdateDeleteSportFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.itemView.cardViewSport.setOnClickListener {
            val action =
                SportFragmentDirections.actionSportNavDrawerToDetailSportFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return sportList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(sport: List<SportTable>) {
        this.sportList = sport
        notifyDataSetChanged()
    }

}