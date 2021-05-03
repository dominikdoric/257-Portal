package Portal.adapter

import Portal.a257.databinding.JedanRedSportBinding
import Portal.model.SportTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class SportAdapter(options: FirestoreRecyclerOptions<SportTable>) :
    FirestoreRecyclerAdapter<SportTable, SportAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            JedanRedSportBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, model: SportTable) {

        holder.naslov.text = model.naslov
        holder.clanak.text = model.clanak
        holder.vrijeme.text = model.vrijeme

    }

    class PersonViewHolder(val binding: JedanRedSportBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}
