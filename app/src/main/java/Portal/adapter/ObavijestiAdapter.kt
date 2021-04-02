package Portal.adapter

import Portal.a257.databinding.JedanRedObavijestiBinding
import Portal.database.table.ObavijestiTable
import Portal.fragmenti.fragmenti.ObavijestiFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ObavijestiAdapter() : RecyclerView.Adapter<ObavijestiAdapter.ViewHolder>() {

    private var obavijestiList = emptyList<ObavijestiTable>()
    private lateinit var binding: JedanRedObavijestiBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ObavijestiAdapter.ViewHolder {
        val binding = JedanRedObavijestiBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObavijestiAdapter.ViewHolder, position: Int) {
        val currentItem = obavijestiList[position]
        binding.textViewObavijestNaslov.text = currentItem.obavijestiNaslov
        binding.textViewObavijestVrijeme.text = currentItem.obavijestiVrijeme

        binding.cardViewObavijesti.setOnLongClickListener {
            val action =
                ObavijestiFragmentDirections.actionObavijestiNavDrawerToUpdateDeleteObavijestiFragment2(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        binding.cardViewObavijesti.setOnClickListener {
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

    inner class ViewHolder(binding: JedanRedObavijestiBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(obavijesti: List<ObavijestiTable>) {
        this.obavijestiList = obavijesti
        notifyDataSetChanged()
    }

}