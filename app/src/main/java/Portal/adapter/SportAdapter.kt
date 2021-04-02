package Portal.adapter

import Portal.a257.databinding.JedanRedSportBinding
import Portal.database.table.SportTable
import Portal.fragmenti.fragmenti.SportFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class SportAdapter() : RecyclerView.Adapter<SportAdapter.ViewHolder>() {

    private var sportList = emptyList<SportTable>()
    private lateinit var binding: JedanRedSportBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportAdapter.ViewHolder {
        val binding = JedanRedSportBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SportAdapter.ViewHolder, position: Int) {
        val currentItem = sportList[position]
        binding.textViewSportNaslov.text = currentItem.sportNaslov
        binding.textViewSportVrijeme.text = currentItem.sportVrijeme

        binding.cardViewSport.setOnLongClickListener {
            val action =
                SportFragmentDirections.actionSportNavDrawerToUpdateDeleteSportFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

        binding.cardViewSport.setOnClickListener {
            val action =
                SportFragmentDirections.actionSportNavDrawerToDetailSportFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return sportList.size
    }

    inner class ViewHolder(binding: JedanRedSportBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(sport: List<SportTable>) {
        this.sportList = sport
        notifyDataSetChanged()
    }

}