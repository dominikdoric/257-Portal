package Portal.adapter

import Portal.a257.databinding.JedanRedSportBinding
import Portal.fragmenti.fragmenti.SportFragmentDirections
import Portal.model.SportTable
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*

class SportAdapter(options: FirestoreRecyclerOptions<SportTable>) :
    FirestoreRecyclerAdapter<SportTable, SportAdapter.SportViewHolder>(options) {

    private lateinit var auth: FirebaseAuth

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        return SportViewHolder(
            JedanRedSportBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: SportViewHolder, position: Int, model: SportTable) {

        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())
        auth = FirebaseAuth.getInstance()

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.naslov


            holder.binding.cardViewSport.setOnClickListener { v: View ->
                val data = SportTable(model.naslov, model.clanak)
                val action = SportFragmentDirections.actionSportNavDrawerToDetailSport(data)
                v.findNavController().navigate(action)
            }

        if (auth.currentUser != null) {
            holder.binding.cardViewSport.setOnLongClickListener { v: View ->
                val data = SportTable(model.naslov, model.clanak)
                val action = SportFragmentDirections.actionSportNavDrawerToUpdateDeleteSport(data)
                v.findNavController().navigate(action)
                true
            }
        }

    }

    class SportViewHolder(val binding: JedanRedSportBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var slika = binding.slika
        var vrijeme = binding.vrijeme
    }
}
