package Portal.pokus

import Portal.a257.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UlovljenaRibaAdapter: RecyclerView.Adapter<UlovljenaRibaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UlovljenaRibaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokus_jedan_red_ulovljene_ribe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UlovljenaRibaAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}