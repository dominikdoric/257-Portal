package Portal.adapter

import Portal.a257.R
import Portal.database.table.OglasnikTable
import Portal.fragmenti.fragmenti.OglasnikFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_oglasnik.view.*

class OglasnikAdapter() : RecyclerView.Adapter<OglasnikAdapter.ViewHolder>() {

    private var oglasnikList = emptyList<OglasnikTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OglasnikAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_oglasnik, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: OglasnikAdapter.ViewHolder, position: Int) {
        val currentItem = oglasnikList[position]
        holder.itemView.textViewOglasnikNaslov.text = currentItem.oglasnikNaslov
        holder.itemView.textViewOglasnikCijena.text = currentItem.oglasnikCijena
        holder.itemView.textViewOglasnikLokacija.text = currentItem.oglasnikLokacija
        holder.itemView.textViewOglasnikBroj.text = currentItem.oglasnikBroj
        holder.itemView.textViewOglasnikVrijeme.text = currentItem.oglasnikVrijeme

        holder.itemView.cardViewOglasnik.setOnLongClickListener {
            val action =
                OglasnikFragmentDirections.actionOglasnikNavDrawerToUpdateDeleteOglasnikFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.itemView.cardViewOglasnik.setOnClickListener {
            val action = OglasnikFragmentDirections.actionOglasnikNavDrawerToDetailOglasnikFragment(
                currentItem
            )
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return oglasnikList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(oglasnik: List<OglasnikTable>) {
        this.oglasnikList = oglasnik
        notifyDataSetChanged()
    }
}