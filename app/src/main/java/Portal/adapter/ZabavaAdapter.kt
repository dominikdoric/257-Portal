package Portal.adapter

import Portal.a257.databinding.JedanRedZabavaBinding
import Portal.database.table.ZabavaTable
import Portal.fragmenti.fragmenti.ZabavaFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ZabavaAdapter() : RecyclerView.Adapter<ZabavaAdapter.ViewHolder>() {

    private var zabavaList = emptyList<ZabavaTable>()
    private lateinit var binding: JedanRedZabavaBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZabavaAdapter.ViewHolder {
        val binding = JedanRedZabavaBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ZabavaAdapter.ViewHolder, position: Int) {
        val currentItem = zabavaList[position]
        binding.textViewZabavaNaslov.text = currentItem.zabavaNaslov
        binding.textViewZabavaVrijeme.text = currentItem.zabavaVrijeme

        binding.cardViewZabava.setOnLongClickListener {
            val action = ZabavaFragmentDirections.actionZabavaNavDrawerToUpdateDeleteZabavaFragment(
                currentItem
            )
            holder.itemView.findNavController().navigate(action)
            true
        }

        binding.cardViewZabava.setOnClickListener {
            val action =
                ZabavaFragmentDirections.actionZabavaNavDrawerToDetailFragmentZabava(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return zabavaList.size
    }

    inner class ViewHolder(binding: JedanRedZabavaBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(zabava: List<ZabavaTable>) {
        this.zabavaList = zabava
        notifyDataSetChanged()
    }
}
