package Portal.firestore

import Portal.a257.R
import Portal.database.table.SportTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.firestore_jedan_red_sport.view.*

class FirestoreSportAdapter(options: FirestoreRecyclerOptions<SportModel>): FirestoreRecyclerAdapter<SportModel,FirestoreSportAdapter.ViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.firestore_jedan_red_sport,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: SportModel) {

        holder.sportNaslov.text = model.sportNaslov
        holder.sportVrijeme.text = model.sportVrijeme

        holder.itemView.firestoreCardViewSport.setOnClickListener {
            val action = FirestoreSportFragmentDirections.actionFirestoreSportFragmentToFirebaseSportDetailFragment()
            holder.itemView.findNavController().navigate(action)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var sportNaslov = itemView.firestoreSportNaslov
        var sportVrijeme = itemView.firestoreSportVrijeme
    }
}