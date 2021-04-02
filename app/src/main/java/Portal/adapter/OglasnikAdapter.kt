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
    private lateinit var binding: JedanRedOglasnikBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OglasnikAdapter.ViewHolder {
        val binding = JedanRedOglasnikBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OglasnikAdapter.ViewHolder, position: Int) {
        val currentItem = oglasnikList[position]
        binding.textViewOglasnikNaslov.text = currentItem.oglasnikNaslov
        binding.textViewOglasnikCijena.text = currentItem.oglasnikCijena
        binding.textViewOglasnikLokacija.text = currentItem.oglasnikLokacija
        binding.textViewOglasnikBroj.text = currentItem.oglasnikBroj
        binding.textViewOglasnikVrijeme.text = currentItem.oglasnikVrijeme

        binding.cardViewOglasnik.setOnLongClickListener {
            val action =
                OglasnikFragmentDirections.actionOglasnikNavDrawerToUpdateDeleteOglasnikFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        binding.cardViewOglasnik.setOnClickListener {
            val action = OglasnikFragmentDirections.actionOglasnikNavDrawerToDetailOglasnikFragment(
                currentItem
            )
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return oglasnikList.size
    }

    inner class ViewHolder(binding: JedanRedOglasnikBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(oglasnik: List<OglasnikTable>) {
        this.oglasnikList = oglasnik
        notifyDataSetChanged()
    }
}