package Portal.adapter

import Portal.a257.databinding.JedanRedObavijestiBinding
import Portal.database.table.ObavijestiTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class ObavijestiAdapter(options: FirestoreRecyclerOptions<ObavijestiTable>) :
    FirestoreRecyclerAdapter<ObavijestiTable, ObavijestiAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            JedanRedObavijestiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, model: ObavijestiTable) {

        holder.naslov.text = model.obavijestiNaslov
        holder.clanak.text = model.obavijestiClanak
        holder.vrijeme.text = model.obavijestiVrijeme

    }

    class PersonViewHolder(val binding: JedanRedObavijestiBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}