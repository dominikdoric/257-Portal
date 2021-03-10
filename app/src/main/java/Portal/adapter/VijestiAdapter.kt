package Portal.adapter

import Portal.a257.R
import Portal.database.table.VijestiTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_vijesti.view.*

class VijestiAdapter(private val listener: VijestiAdapter.OnItemClickListener): RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

    private var vijestiList = emptyList<VijestiTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VijestiAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_vijesti, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VijestiAdapter.ViewHolder, position: Int) {
        val currentItem = vijestiList[position]
        holder.itemView.textViewVijestiNaslov.text = currentItem.vijestiNaslov
        holder.itemView.textViewVijestiVrijeme.text = currentItem.vijestiVrijeme
    }

    override fun getItemCount(): Int {
        return vijestiList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setData(vijesti: List<VijestiTable>){
        this.vijestiList = vijesti
        notifyDataSetChanged()
    }


}