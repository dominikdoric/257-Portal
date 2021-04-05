package Portal.adapter.adminAdapter

import Portal.a257.R
import Portal.database.table.ZabavaTable
import Portal.fragmenti.admin.odobri.AdminOdobriZabavuDirections
import Portal.fragmenti.fragmenti.ZabavaFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_zabava.view.*

class AdminZabavaAdapter() : RecyclerView.Adapter<AdminZabavaAdapter.ViewHolder>() {

    private var zabavaList = emptyList<ZabavaTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminZabavaAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_zabava, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdminZabavaAdapter.ViewHolder, position: Int) {
        val currentItem = zabavaList[position]
        holder.itemView.textViewZabavaNaslov.text = currentItem.zabavaNaslov
        holder.itemView.textViewZabavaVrijeme.text = currentItem.zabavaVrijeme

        holder.itemView.cardViewZabava.setOnClickListener {
            val action =
                AdminOdobriZabavuDirections.actionAdminOdobriZabavuToAdminPotvrdiZabavu(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return zabavaList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(zabava: List<ZabavaTable>) {
        this.zabavaList = zabava
        notifyDataSetChanged()
    }
}