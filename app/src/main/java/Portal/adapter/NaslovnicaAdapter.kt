package Portal.adapter

import Portal.a257.R
import Portal.database.table.SportTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NaslovnicaAdapter() : RecyclerView.Adapter<NaslovnicaAdapter.ViewHolder>() {

    private var sportList = emptyList<SportTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NaslovnicaAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_naslovnica, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NaslovnicaAdapter.ViewHolder, position: Int) {
        val currentItem = sportList[position]


    }

    override fun getItemCount(): Int {
        return (sportList.size)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(sport: List<SportTable>) {
        this.sportList = sport
        notifyDataSetChanged()
    }

}