package Portal.firestore

import Portal.a257.R
import Portal.a257.databinding.FirestoreJedanRedBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class FirestoreAdapter(options: FirestoreRecyclerOptions<Person>) :
    FirestoreRecyclerAdapter<Person, FirestoreAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            FirestoreJedanRedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, model: Person) {
        holder.firstName.text = model.firstName
        holder.lastName.text = model.lastName
        holder.age.text = model.age.toString()
    }

    class PersonViewHolder(val binding: FirestoreJedanRedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var firstName = binding.rowFirstName
        var lastName = binding.rowFirstName
        var age = binding.rowAge
    }

}