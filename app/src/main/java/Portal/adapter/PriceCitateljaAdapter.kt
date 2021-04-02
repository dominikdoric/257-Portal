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
    private lateinit var binding: JedanRedPriceCitateljaBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PriceCitateljaAdapter.ViewHolder {
        val binding = JedanRedPriceCitateljaBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PriceCitateljaAdapter.ViewHolder, position: Int) {
        val currentItem = priceCitateljaList[position]
        binding.textViewPricaCitateljaNaslov.text = currentItem.priceCitateljaNaslov
        binding.textViewPricaCitateljaVrijeme.text = currentItem.priceCitateljaVrijeme

        binding.cardViewPricaCitatelja.setOnLongClickListener {
            val action =
                PriceCitateljaFragmentDirections.actionPriceCitateljaNavDrawerToUpdateDeletePriceCitateljaFragment(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

        binding.cardViewPricaCitatelja.setOnClickListener {
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

    inner class ViewHolder(binding: JedanRedPriceCitateljaBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(priceCitatelja: List<PriceCitateljaTable>) {
        this.priceCitateljaList = priceCitatelja
        notifyDataSetChanged()
    }

}