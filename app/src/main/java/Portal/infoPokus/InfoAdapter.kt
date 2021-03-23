package Portal.infoPokus

import Portal.database.table.InfoTable
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class InfoAdapter: RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    private var infoList = emptyList<InfoTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: InfoAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(infoTable: List<InfoTable>){
        this.infoList = infoTable
        notifyDataSetChanged()
    }

}