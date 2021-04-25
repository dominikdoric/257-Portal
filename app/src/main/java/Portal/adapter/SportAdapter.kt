package Portal.adapter

import Portal.a257.databinding.JedanRedSportBinding
import Portal.a257.databinding.JedanRedVijestiBinding
import Portal.database.table.SportTable
import Portal.database.table.VijestiTable
import Portal.fragmenti.fragmenti.VijestiFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class SportAdapter: RecyclerView.Adapter<SportAdapter.ViewHolder>()  {

    private var sportList = emptyList<SportTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportAdapter.ViewHolder {
        return ViewHolder(
            JedanRedSportBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SportAdapter.ViewHolder, position: Int) {
        val currentItem = sportList[position]
        holder.binding.textViewSportNaslov.text = currentItem.sportNaslov
        holder.binding.textViewSportVrijeme.text = currentItem.sportVrijeme

        /*
        holder.binding.cardViewSport.setOnLongClickListener {
            val action =
                VijestiFragmentDirections.actionVijestiNavDrawerToAdminPrijavaVijestiFragment()
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.cardViewSport.setOnClickListener {
            val action =
                VijestiFragmentDirections.actionVijestiNavDrawerToDetailVijestiFragment()
            holder.itemView.findNavController().navigate(action)
        }
         */
    }

    override fun getItemCount(): Int {
        return sportList.size
    }

    inner class ViewHolder(val binding: JedanRedSportBinding): RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(sport: List<SportTable>) {
        this.sportList = sport
        notifyDataSetChanged()
    }
}