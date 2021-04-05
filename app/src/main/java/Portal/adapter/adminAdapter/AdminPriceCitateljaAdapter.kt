package Portal.adapter.adminAdapter

import Portal.a257.R
import Portal.database.table.PriceCitateljaTable
import Portal.fragmenti.admin.odobri.AdminOdobriPriceCitateljaDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_price_citatelja.view.*

class AdminPriceCitateljaAdapter : RecyclerView.Adapter<AdminPriceCitateljaAdapter.ViewHolder>() {

    private var priceCitateljaList = emptyList<PriceCitateljaTable>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdminPriceCitateljaAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_price_citatelja, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdminPriceCitateljaAdapter.ViewHolder, position: Int) {
        val currentItem = priceCitateljaList[position]
        holder.itemView.textViewPricaCitateljaNaslov.text = currentItem.priceCitateljaNaslov
        holder.itemView.textViewPricaCitateljaVrijeme.text = currentItem.priceCitateljaVrijeme

        holder.itemView.cardViewPricaCitatelja.setOnClickListener {
            val action =
                AdminOdobriPriceCitateljaDirections.actionAdminOdobriPriceCitateljaToAdminPotvrdiPriceCitatelja()
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return priceCitateljaList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(priceCitatelja: List<PriceCitateljaTable>) {
        this.priceCitateljaList = priceCitatelja
        notifyDataSetChanged()
    }

}