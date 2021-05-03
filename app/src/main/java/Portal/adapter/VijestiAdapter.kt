package Portal.adapter

import Portal.a257.databinding.JedanRedVijestiBinding
import Portal.database.table.VijestiTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class VijestiAdapter(options: FirestoreRecyclerOptions<VijestiTable>) :
    FirestoreRecyclerAdapter<VijestiTable, VijestiAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            JedanRedVijestiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, model: VijestiTable) {

        holder.naslov.text = model.vijestiNaslov
        holder.clanak.text = model.vijestiClanak
        holder.vrijeme.text = model.vijestiVrijeme

    }

    class PersonViewHolder(val binding: JedanRedVijestiBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}


