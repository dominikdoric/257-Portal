package Portal.infoPokus

import Portal.a257.R
import Portal.database.table.InfoTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_info.view.*

class InfoAdapter: RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    private var infoList = emptyList<InfoTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: InfoAdapter.ViewHolder, position: Int) {
        val currentItem = infoList[position]
        holder.itemView.infoTextViewIme.text = currentItem.ime
        holder.itemView.infoTextViewPrezime.text = currentItem.prezime

        holder.itemView.jedan_red_info.setOnLongClickListener {
            val action = InfoFragmentDirections.actionInfoBottomNavToUpdateDeleteInfoFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }
    }

    override fun getItemCount(): Int {
        return infoList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(infoTable: List<InfoTable>){
        this.infoList = infoTable
        notifyDataSetChanged()
    }

}