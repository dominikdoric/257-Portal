package Portal.adapter

import Portal.a257.R
import Portal.database.table.PriceCitateljaTable
import Portal.database.table.SportTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_price_citatelja.view.*

class PriceCitateljaAdapter: RecyclerView.Adapter<PriceCitateljaAdapter.ViewHolder>() {

    private var priceCitateljaList = emptyList<PriceCitateljaTable>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PriceCitateljaAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_price_citatelja, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PriceCitateljaAdapter.ViewHolder, position: Int) {
        val currentItem = priceCitateljaList[position]
        holder.itemView.textViewPricaCitateljaNaslov.text = currentItem.priceCitateljaNaslov
        holder.itemView.textViewPricaCitateljaVrijeme.text = currentItem.priceCitateljaVrijeme
    }

    override fun getItemCount(): Int {
        return priceCitateljaList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(priceCitatelja: List<PriceCitateljaTable>) {
        this.priceCitateljaList = priceCitatelja
        notifyDataSetChanged()
    }

}