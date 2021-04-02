package Portal.adapter

import Portal.a257.R
import Portal.database.table.PoljoprivredaTable
import Portal.fragmenti.fragmenti.PoljoprivredaFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_sport.view.*

class PoljoprivredaAdapter() : RecyclerView.Adapter<PoljoprivredaAdapter.ViewHolder>() {

    private var poljoprivredaList = emptyList<PoljoprivredaTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoljoprivredaAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_poljoprivreda, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportAdapter.ViewHolder, position: Int) {
        val currentItem = poljoprivredaList[position]
        holder.itemView.textViewPoljoprivredaNaslov.text = currentItem.poljoprivredaNaslov
        holder.itemView.textViewPoljoprivredaVrijeme.text = currentItem.poljoprivredaVrijeme

        holder.itemView.cardViewPoljoprivreda.setOnLongClickListener {
            val action =
                PoljoprivredaFragmentDirections.actionPoljoprivredaNavDrawerToUpdateDeletePoljoprivredaFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.itemView.cardViewPoljoprivreda.setOnClickListener {
            val action =
                PoljoprivredaFragmentDirections.actionPoljoprivredaNavDrawerToDetailPoljoprivredaFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return poljoprivredaList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(poljoprivreda: List<PoljoprivredaTable>) {
        this.poljoprivredaList = poljoprivreda
        notifyDataSetChanged()
    }

}