package Portal.firestore

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class FirestoreAdapter(options: FirestoreRecyclerOptions<UserModel>) :
    FirestoreRecyclerAdapter<UserModel, FirestoreAdapter.UserAdapterViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserAdapterViewHolder, position: Int, model: UserModel) {
        TODO("Not yet implemented")
    }

    class UserAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}