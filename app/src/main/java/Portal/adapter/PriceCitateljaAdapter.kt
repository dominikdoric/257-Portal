package Portal.adapter

import Portal.a257.databinding.JedanRedPriceCitateljaBinding
import Portal.database.table.PriceCitateljaTable
import Portal.fragmenti.fragmenti.PriceCitateljaFragmentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class PriceCitateljaAdapter : RecyclerView.Adapter<PriceCitateljaAdapter.ViewHolder>() {

    private var priceCitateljaList = emptyList<PriceCitateljaTable>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PriceCitateljaAdapter.ViewHolder {
        return ViewHolder(
            JedanRedPriceCitateljaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PriceCitateljaAdapter.ViewHolder, position: Int) {
        val currentItem = priceCitateljaList[position]
        holder.binding.textViewPricaCitateljaNaslov.text = currentItem.priceCitateljaNaslov
        holder.binding.textViewPricaCitateljaVrijeme.text = currentItem.priceCitateljaVrijeme

        holder.binding.cardViewPricaCitatelja.setOnLongClickListener {
            val action =
                PriceCitateljaFragmentDirections.actionPriceCitateljaNavDrawerToAdminPrijavaPriceCitateljaFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.cardViewPricaCitatelja.setOnClickListener {
            val action =
                PriceCitateljaFragmentDirections.actionPriceCitateljaNavDrawerToDetailPriceCitateljaFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return priceCitateljaList.size
    }

    inner class ViewHolder(val binding: JedanRedPriceCitateljaBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(priceCitatelja: List<PriceCitateljaTable>) {
        this.priceCitateljaList = priceCitatelja
        notifyDataSetChanged()
    }

}