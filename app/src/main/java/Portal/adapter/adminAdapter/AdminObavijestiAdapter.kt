package Portal.adapter.adminAdapter

import Portal.a257.R
import Portal.database.table.ObavijestiTable
import Portal.fragmenti.admin.odobri.AdminOdobriObavijestiDirections
import Portal.fragmenti.fragmenti.ObavijestiFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_obavijesti.view.*

class AdminObavijestiAdapter() : RecyclerView.Adapter<AdminObavijestiAdapter.ViewHolder>() {

    private var obavijestiList = emptyList<ObavijestiTable>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdminObavijestiAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_obavijesti, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdminObavijestiAdapter.ViewHolder, position: Int) {
        val currentItem = obavijestiList[position]
        holder.itemView.textViewObavijestNaslov.text = currentItem.obavijestiNaslov
        holder.itemView.textViewObavijestVrijeme.text = currentItem.obavijestiVrijeme

        holder.itemView.cardViewObavijesti.setOnClickListener {
            val action =
                AdminOdobriObavijestiDirections.actionAdminOdobriObavijestiToAdminPotvrdiObavijesti()
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return obavijestiList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(obavijesti: List<ObavijestiTable>) {
        this.obavijestiList = obavijesti
        notifyDataSetChanged()
    }

}