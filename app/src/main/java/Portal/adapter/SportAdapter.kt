package Portal.adapter

import Portal.a257.R
import Portal.a257.databinding.JedanRedSportBinding
import Portal.database.table.SportTable
import Portal.firestore.FirestoreSportAdapter
import Portal.firestore.SportModel
import Portal.fragmenti.fragmenti.SportFragmentDirections
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.jedan_red_sport.view.*

class SportAdapter(options: FirestoreRecyclerOptions<SportModel>) :
    FirestoreRecyclerAdapter<SportModel, SportAdapter.ViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_sport, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: SportModel) {
        holder.sportNaslov.text = model.sportNaslov
        holder.sportVrijeme.text = model.sportVrijeme
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sportNaslov = itemView.textViewSportNaslov
        var sportVrijeme = itemView.textViewSportVrijeme
    }
}