package Portal.adapter

import Portal.a257.R
import Portal.database.table.OglasnikTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jedan_red_oglasnik.view.*

class OglasnikAdapter(
    private val listener: OnItemClickListener,
    private val listenerLong: OnItemLongClickListener
) : RecyclerView.Adapter<OglasnikAdapter.ViewHolder>() {

    private var oglasnikList = emptyList<OglasnikTable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OglasnikAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_oglasnik, parent, false)
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val naslovOglasnik = oglasnikList.get(adapterPosition).oglasnikNaslov
            val clanakOglasnik = oglasnikList.get(adapterPosition).oglasnikClanak
            val cijenaOglasnik = oglasnikList.get(adapterPosition).oglasnikCijena
            val lokacijaOglasnik = oglasnikList.get(adapterPosition).oglasnikLokacija
            val brojOglasnik = oglasnikList.get(adapterPosition).oglasnikBroj
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(
                    position,
                    naslovOglasnik,
                    clanakOglasnik,
                    cijenaOglasnik,
                    lokacijaOglasnik,
                    brojOglasnik
                )
            }
        }

        override fun onLongClick(v: View?): Boolean {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listenerLong.onItemLongClick(position)
            }
            return true
        }
    }

    interface OnItemClickListener {
        fun onItemClick(
            position: Int,
            naslovOglasnik: String,
            clanakOglasnik: String,
            cijenaOglasnik: String,
            lokacijaOglasnik: String,
            brojOglasnik: String
        )
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(position: Int)
    }

    fun setData(oglasnik: List<OglasnikTable>) {
        this.oglasnikList = oglasnik
        notifyDataSetChanged()
    }

}