package Portal.adapter

import Portal.a257.databinding.JedanRedOglasnikBinding
import Portal.database.table.OglasnikTable
import Portal.fragmenti.fragmenti.OglasnikFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class OglasnikAdapter() : RecyclerView.Adapter<OglasnikAdapter.ViewHolder>() {

    private var oglasnikList = emptyList<OglasnikTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OglasnikAdapter.ViewHolder {
        return ViewHolder(
            JedanRedOglasnikBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: OglasnikAdapter.ViewHolder, position: Int) {
        val currentItem = oglasnikList[position]
        holder.binding.textViewOglasnikNaslov.text = currentItem.oglasnikNaslov
        holder.binding.textViewOglasnikCijena.text = currentItem.oglasnikCijena
        holder.binding.textViewOglasnikLokacija.text = currentItem.oglasnikLokacija
        holder.binding.textViewOglasnikBroj.text = currentItem.oglasnikBroj
        holder.binding.textViewOglasnikVrijeme.text = currentItem.oglasnikVrijeme

        holder.binding.cardViewOglasnik.setOnLongClickListener {
            val action =
                OglasnikFragmentDirections.actionOglasnikNavDrawerToAdminPrijavaOglasnikFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.cardViewOglasnik.setOnClickListener {
            val action = OglasnikFragmentDirections.actionOglasnikNavDrawerToDetailOglasnikFragment(
                currentItem
            )
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return oglasnikList.size
    }

    inner class ViewHolder(val binding: JedanRedOglasnikBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(oglasnik: List<OglasnikTable>) {
        this.oglasnikList = oglasnik
        notifyDataSetChanged()
    }
}