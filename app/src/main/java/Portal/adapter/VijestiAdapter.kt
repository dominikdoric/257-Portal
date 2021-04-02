package Portal.adapter

import Portal.a257.R
import Portal.a257.databinding.JedanRedVijestiBinding
import Portal.database.table.VijestiTable
import Portal.fragmenti.fragmenti.VijestiFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_vijesti.view.*

class VijestiAdapter() : RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

    private var vijestiList = emptyList<VijestiTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VijestiAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_oglasnik, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VijestiAdapter.ViewHolder, position: Int) {
        val currentItem = vijestiList[position]
        holder.itemView.textViewVijestiNaslov.text = currentItem.vijestiNaslov
        holder.itemView.textViewVijestiVrijeme.text = currentItem.vijestiVrijeme

        holder.itemView.cardViewVijesti.setOnLongClickListener {
            val action =
                VijestiFragmentDirections.actionVijestiNavDrawerToUpdateDeleteVijestiFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.itemView.cardViewVijesti.setOnClickListener {
            val action =
                VijestiFragmentDirections.actionVijestiNavDrawerToDetailVijestiFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return vijestiList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(vijesti: List<VijestiTable>) {
        this.vijestiList = vijesti
        notifyDataSetChanged()
    }
}


