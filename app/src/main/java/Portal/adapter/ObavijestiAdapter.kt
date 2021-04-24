package Portal.adapter

import Portal.a257.R
import Portal.a257.databinding.JedanRedObavijestiBinding
import Portal.database.table.ObavijestiTable
import Portal.fragmenti.fragmenti.ObavijestiFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ObavijestiAdapter() : RecyclerView.Adapter<ObavijestiAdapter.ViewHolder>() {

    private var obavijestiList = emptyList<ObavijestiTable>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ObavijestiAdapter.ViewHolder {
        return ViewHolder(
            JedanRedObavijestiBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: ObavijestiAdapter.ViewHolder, position: Int) {
        val currentItem = obavijestiList[position]
        holder.binding.textViewObavijestNaslov.text = currentItem.obavijestiNaslov
        holder.binding.textViewObavijestVrijeme.text = currentItem.obavijestiVrijeme

        holder.binding.cardViewObavijesti.setOnLongClickListener {
            val action =
                ObavijestiFragmentDirections.actionObavijestiNavDrawerToAdminPrijavaObavijestiFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.cardViewObavijesti.setOnClickListener {
            val action =
                ObavijestiFragmentDirections.actionObavijestiNavDrawerToDetailObavijestiFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return obavijestiList.size
    }

    inner class ViewHolder(val binding: JedanRedObavijestiBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(obavijesti: List<ObavijestiTable>) {
        this.obavijestiList = obavijesti
        notifyDataSetChanged()
    }

}