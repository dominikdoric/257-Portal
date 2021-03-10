package Portal.adapter

import Portal.a257.R
import Portal.database.table.OglasnikTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_oglasnik.view.*

class OglasnikAdapter(private val listener: OglasnikAdapter.OnItemClickListener): RecyclerView.Adapter<OglasnikAdapter.ViewHolder>() {

    private var oglasnikList = emptyList<OglasnikTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OglasnikAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_oglasnik, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: OglasnikAdapter.ViewHolder, position: Int) {
        val currentItem = oglasnikList[position]
        holder.itemView.textViewOglasnikNaslov.text = currentItem.oglasnikNaslov
        holder.itemView.textViewOglasnikCijena.text = currentItem.oglasnikCijena
        holder.itemView.textViewOglasnikLokacija.text = currentItem.oglasnikLokacija
        holder.itemView.textViewOglasnikBroj.text = currentItem.oglasnikBroj
        holder.itemView.textViewOglasnikVrijeme.text = currentItem.oglasnikVrijeme
    }

    override fun getItemCount(): Int {
        return oglasnikList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) , View.OnClickListener{
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

    fun setData(oglasnik: List<OglasnikTable>){
        this.oglasnikList = oglasnik
        notifyDataSetChanged()
    }

}