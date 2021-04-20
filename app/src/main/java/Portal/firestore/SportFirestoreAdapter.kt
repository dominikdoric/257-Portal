package Portal.firestore

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.firestore_jedan_red.view.*

class SportFirestoreAdapter(options: FirestoreRecyclerOptions<SportModel>) :
    FirestoreRecyclerAdapter<SportModel, FirestoreAdapter.UserAdapterViewHolder>(options) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirestoreAdapter.UserAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: FirestoreAdapter.UserAdapterViewHolder,
        position: Int,
        model: SportModel
    ) {
        TODO("Not yet implemented")
    }

    class UserAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}