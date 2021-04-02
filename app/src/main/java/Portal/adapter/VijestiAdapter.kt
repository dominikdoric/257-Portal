package Portal.adapter

import Portal.a257.databinding.JedanRedVijestiBinding
import Portal.database.table.VijestiTable
import Portal.fragmenti.fragmenti.VijestiFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class VijestiAdapter() : RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

    private var vijestiList = emptyList<VijestiTable>()
    private lateinit var binding: JedanRedVijestiBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VijestiAdapter.ViewHolder {
        val binding = JedanRedVijestiBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VijestiAdapter.ViewHolder, position: Int) {
        val currentItem = vijestiList[position]
        binding.textViewVijestiNaslov.text = currentItem.vijestiNaslov
        binding.textViewVijestiVrijeme.text = currentItem.vijestiVrijeme

        binding.cardViewVijesti.setOnLongClickListener {
            val action =
                VijestiFragmentDirections.actionVijestiNavDrawerToUpdateDeleteVijestiFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        binding.cardViewVijesti.setOnClickListener {
            val action =
                VijestiFragmentDirections.actionVijestiNavDrawerToDetailVijestiFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return vijestiList.size
    }

    inner class ViewHolder(binding: JedanRedVijestiBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(vijesti: List<VijestiTable>) {
        this.vijestiList = vijesti
        notifyDataSetChanged()
    }
}


