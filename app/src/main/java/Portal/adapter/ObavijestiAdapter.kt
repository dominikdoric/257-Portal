package Portal.adapter

import Portal.a257.R
import Portal.database.table.ObavijestiTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_obavijesti.view.*

class ObavijestiAdapter(private val listener: OnItemClickListener,private val listenerLong: OnItemLongClickListener): RecyclerView.Adapter<ObavijestiAdapter.ViewHolder>() {

    private var obavijestiList = emptyList<ObavijestiTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObavijestiAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_obavijesti, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObavijestiAdapter.ViewHolder, position: Int) {
        val currentItem = obavijestiList[position]
        holder.itemView.textViewObavijestNaslov.text = currentItem.obavijestiNaslov
        holder.itemView.textViewObavijestVrijeme.text = currentItem.obavijestiVrijeme
    }

    override fun getItemCount(): Int {
        return obavijestiList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener,View.OnLongClickListener {
        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val naslovObavijesti = obavijestiList.get(adapterPosition).obavijestiNaslov
            val clanakObavijesti = obavijestiList.get(adapterPosition).obavijestiClanak
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position,naslovObavijesti,clanakObavijesti)
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
        fun onItemClick(position: Int,naslovObavijesti: String, clanakObavijesti: String)
    }

    interface OnItemLongClickListener{
        fun onItemLongClick(position: Int)
    }

    fun setData(obavijesti: List<ObavijestiTable>){
        this.obavijestiList = obavijesti
        notifyDataSetChanged()
    }

}