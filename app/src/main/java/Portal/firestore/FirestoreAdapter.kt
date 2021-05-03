package Portal.firestore

import Portal.a257.databinding.FirestoreJedanRedBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
