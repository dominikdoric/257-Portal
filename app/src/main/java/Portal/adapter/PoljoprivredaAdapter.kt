package Portal.adapter

import Portal.a257.databinding.JedanRedPoljoprivredaBinding
import Portal.database.table.PoljoprivredaTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class PoljoprivredaAdapter(options: FirestoreRecyclerOptions<PoljoprivredaTable>) :
    FirestoreRecyclerAdapter<PoljoprivredaTable, PoljoprivredaAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            JedanRedPoljoprivredaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: PersonViewHolder,
        position: Int,
        model: PoljoprivredaTable
    ) {

        holder.naslov.text = model.poljoprivredaNaslov
        holder.clanak.text = model.poljoprivredaClanak
        holder.vrijeme.text = model.poljoprivredaVrijeme

    }

    class PersonViewHolder(val binding: JedanRedPoljoprivredaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}