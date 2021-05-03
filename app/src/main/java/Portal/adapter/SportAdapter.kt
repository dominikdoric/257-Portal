package Portal.adapter

import Portal.a257.databinding.FirestoreJedanRedBinding
import Portal.firestore.SportFirestore
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class SportAdapter(options: FirestoreRecyclerOptions<SportFirestore>) :
    FirestoreRecyclerAdapter<SportFirestore, SportAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            FirestoreJedanRedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, model: SportFirestore) {

        holder.firstName.text = model.naslov
        holder.lastName.text = model.clanak
        holder.age.text = model.vrijeme

    }

    class PersonViewHolder(val binding: FirestoreJedanRedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var firstName = binding.rowFirstName
        var lastName = binding.rowLastName
        var age = binding.rowAge
    }
}
