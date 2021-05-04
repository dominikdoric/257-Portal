package Portal.adapter

import Portal.a257.databinding.JedanRedObavijestiBinding
import Portal.model.ObavijestiTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import java.text.SimpleDateFormat
import java.util.*

class ObavijestiAdapter(options: FirestoreRecyclerOptions<ObavijestiTable>) :
    FirestoreRecyclerAdapter<ObavijestiTable, ObavijestiAdapter.ObavijestiViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObavijestiViewHolder {
        return ObavijestiViewHolder(
            JedanRedObavijestiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ObavijestiViewHolder, position: Int, model: ObavijestiTable) {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.obavijestiNaslov
        holder.clanak.text = model.obavijestiClanak

    }

    class ObavijestiViewHolder(val binding: JedanRedObavijestiBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}