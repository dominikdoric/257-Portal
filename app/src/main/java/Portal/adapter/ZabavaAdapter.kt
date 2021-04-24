package Portal.adapter

import Portal.a257.R
import Portal.a257.databinding.JedanRedZabavaBinding
import Portal.database.table.ZabavaTable
import Portal.fragmenti.fragmenti.ZabavaFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ZabavaAdapter : RecyclerView.Adapter<ZabavaAdapter.ViewHolder>() {

    private var zabavaList = emptyList<ZabavaTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZabavaAdapter.ViewHolder {
        return ViewHolder(
            JedanRedZabavaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ZabavaAdapter.ViewHolder, position: Int) {
        val currentItem = zabavaList[position]
        holder.binding.textViewZabavaNaslov.text = currentItem.zabavaNaslov
        holder.binding.textViewZabavaVrijeme.text = currentItem.zabavaVrijeme

        holder.binding.cardViewZabava.setOnLongClickListener {
            val action = ZabavaFragmentDirections.actionZabavaNavDrawerToAdminPrijavaZabavaFragment(
                currentItem
            )
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.cardViewZabava.setOnClickListener {
            val action =
                ZabavaFragmentDirections.actionZabavaNavDrawerToDetailFragmentZabava(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return zabavaList.size
    }

    inner class ViewHolder(val binding: JedanRedZabavaBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(zabava: List<ZabavaTable>) {
        this.zabavaList = zabava
        notifyDataSetChanged()
    }
}
