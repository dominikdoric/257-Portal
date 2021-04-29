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

class FirestoreAdapter(options: FirestoreRecyclerOptions<Person>): FirestoreRecyclerAdapter<Person, FirestoreAdapter.PersonViewHolder>(options) {

    //private var personList = emptyList<Person>()

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
            //val currentItem = personList[position]

            holder.firstName.text = model.firstName
            holder.lastName.text = model.lastName
            holder.age.text = model.age.toString()

/*
            holder.binding.jedanRedFirestore.setOnClickListener {
                val action =
                    FirestoreRecyclerDirections.actionFirestoreRecyclerToFirestoreDetail(currentItem)
                holder.itemView.findNavController().navigate(action)
            }

 */
    }
/*
    override fun getItemCount(): Int {
        return personList.size
    }

 */

    class PersonViewHolder(val binding: FirestoreJedanRedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var firstName = binding.rowFirstName
        var lastName = binding.rowFirstName
        var age = binding.rowAge
    }
}
