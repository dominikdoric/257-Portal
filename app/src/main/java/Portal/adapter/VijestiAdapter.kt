package Portal.adapter

import Portal.a257.databinding.JedanRedVijestiBinding
import Portal.database.table.VijestiTable
import Portal.fragmenti.fragmenti.VijestiFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class VijestiAdapter : RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

    private var vijestiList = emptyList<VijestiTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VijestiAdapter.ViewHolder {
        return ViewHolder(
            JedanRedVijestiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VijestiAdapter.ViewHolder, position: Int) {
        val currentItem = vijestiList[position]
        holder.binding.textViewVijestiNaslov.text = currentItem.vijestiNaslov
        holder.binding.textViewVijestiVrijeme.text = currentItem.vijestiVrijeme

        holder.binding.cardViewVijesti.setOnLongClickListener {
            val action =
                VijestiFragmentDirections.actionVijestiNavDrawerToAdminPrijavaVijestiFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.cardViewVijesti.setOnClickListener {
            val action =
                VijestiFragmentDirections.actionVijestiNavDrawerToDetailVijestiFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return vijestiList.size
    }

    inner class ViewHolder(val binding: JedanRedVijestiBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(vijesti: List<VijestiTable>) {
        this.vijestiList = vijesti
        notifyDataSetChanged()
    }
}


