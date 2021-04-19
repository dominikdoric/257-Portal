package Portal.firestore

import Portal.a257.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.firestore_jedan_red.view.*

class FirestoreAdapter(options: FirestoreRecyclerOptions<Person>) :
    FirestoreRecyclerAdapter<Person, FirestoreAdapter.UserAdapterViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterViewHolder {
        return UserAdapterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.firestore_jedan_red,parent,false))

    }

    override fun onBindViewHolder(holder: UserAdapterViewHolder, position: Int, model: Person) {
        holder.firstName.text = model.firstName
        holder.lastName.text = model.lastName
        holder.age.text = model.age.toString()
    }

    class UserAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName = itemView.tvUsername
        var lastName = itemView.tvLastname
        var age = itemView.tvAge
    }

}