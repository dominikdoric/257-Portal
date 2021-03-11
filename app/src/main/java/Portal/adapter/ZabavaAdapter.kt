package Portal.adapter

import Portal.a257.R
import Portal.database.table.ZabavaTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.view.*
import kotlinx.android.synthetic.main.jedan_red_zabava.view.*

class ZabavaAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<ZabavaAdapter.ViewHolder>() {

    private var zabavaList = emptyList<ZabavaTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZabavaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_zabava, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZabavaAdapter.ViewHolder, position: Int) {
        val currentItem = zabavaList[position]
        holder.itemView.textViewZabavaNaslov.text = currentItem.zabavaNaslov
        holder.itemView.textViewZabavaVrijeme.text = currentItem.zabavaVrijeme
    }

    override fun getItemCount(): Int {
        return zabavaList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val naslovZabava = zabavaList.get(adapterPosition).zabavaNaslov
            val clanakZabava = zabavaList.get(adapterPosition).zabavaClanak
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position,naslovZabava,clanakZabava)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int,naslovZabava: String,clanakZabava: String)
    }

    fun setData(zabava: List<ZabavaTable>){
        this.zabavaList = zabava
        notifyDataSetChanged()
    }

}