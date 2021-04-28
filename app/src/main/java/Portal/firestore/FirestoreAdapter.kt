package Portal.firestore

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class FirestoreAdapter(options: FirestoreRecyclerOptions<Person>) :
    FirestoreRecyclerAdapter<Person, FirestoreAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, model: Person) {
        TODO("Not yet implemented")
    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

}