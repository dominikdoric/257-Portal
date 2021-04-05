package Portal.adapter.adminAdapter

import Portal.a257.R
import Portal.database.table.VijestiTable
import Portal.fragmenti.admin.odobri.AdminOdobriVijestiDirections
import Portal.fragmenti.fragmenti.VijestiFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_vijesti.view.*

class AdminVijestiAdapter() : RecyclerView.Adapter<AdminVijestiAdapter.ViewHolder>() {

    private var vijestiList = emptyList<VijestiTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminVijestiAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_vijesti, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdminVijestiAdapter.ViewHolder, position: Int) {
        val currentItem = vijestiList[position]
        holder.itemView.textViewVijestiNaslov.text = currentItem.vijestiNaslov
        holder.itemView.textViewVijestiVrijeme.text = currentItem.vijestiVrijeme

        holder.itemView.cardViewVijesti.setOnClickListener {
            val action =
                AdminOdobriVijestiDirections.actionAdminOdobriVijestiToAdminPotvrdiVijesti(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return vijestiList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(vijesti: List<VijestiTable>) {
        this.vijestiList = vijesti
        notifyDataSetChanged()
    }
}