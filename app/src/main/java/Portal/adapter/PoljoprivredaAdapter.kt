package Portal.adapter

import Portal.a257.databinding.JedanRedPoljoprivredaBinding
import Portal.database.table.PoljoprivredaTable
import Portal.fragmenti.fragmenti.PoljoprivredaFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class PoljoprivredaAdapter : RecyclerView.Adapter<PoljoprivredaAdapter.ViewHolder>() {

    private var poljoprivredaList = emptyList<PoljoprivredaTable>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PoljoprivredaAdapter.ViewHolder {
        return ViewHolder(
            JedanRedPoljoprivredaBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PoljoprivredaAdapter.ViewHolder, position: Int) {
        val currentItem = poljoprivredaList[position]
        holder.binding.textViewPoljoprivredaNaslov.text = currentItem.poljoprivredaNaslov
        holder.binding.textViewPoljoprivredaVrijeme.text = currentItem.poljoprivredaVrijeme

        holder.binding.cardViewPoljoprivreda.setOnLongClickListener {
            val action =
                PoljoprivredaFragmentDirections.actionPoljoprivredaNavDrawerToAdminPrijavaPoljoprivradaFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.cardViewPoljoprivreda.setOnClickListener {
            val action =
                PoljoprivredaFragmentDirections.actionPoljoprivredaNavDrawerToDetailPoljoprivredaFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return poljoprivredaList.size
    }

    inner class ViewHolder(val binding: JedanRedPoljoprivredaBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(poljoprivreda: List<PoljoprivredaTable>) {
        this.poljoprivredaList = poljoprivreda
        notifyDataSetChanged()
    }

}