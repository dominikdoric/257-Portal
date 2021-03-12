package Portal.adapter

import Portal.a257.R
import Portal.database.table.VijestiTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_vijesti.view.*

class VijestiAdapter(private val listener: OnItemClickListener,private val listenerLong: OnItemLongClickListener): RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

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

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener,View.OnLongClickListener {
        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val naslovVijesti = vijestiList.get(adapterPosition).vijestiNaslov
            val clanakVijesti = vijestiList.get(adapterPosition).vijestiClanak
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position,naslovVijesti,clanakVijesti)
            }
        }

        override fun onLongClick(v: View?): Boolean {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listenerLong.onItemLongClick(position)
            }
            return true
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int,naslovVijesti: String,clanakVijesti: String)
    }

    interface OnItemLongClickListener{
        fun onItemLongClick(position: Int)
    }

    fun setData(vijesti: List<VijestiTable>){
        this.vijestiList = vijesti
        notifyDataSetChanged()
    }


}