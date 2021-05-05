package Portal.adapter

import Portal.a257.databinding.JedanRedSportBinding
import Portal.fragmenti.fragmenti.SportFragment
import Portal.fragmenti.fragmenti.SportFragmentDirections
import Portal.model.SportTable
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class SportAdapter(options: FirestoreRecyclerOptions<SportTable>) :
    FirestoreRecyclerAdapter<SportTable, SportAdapter.SportViewHolder>(options) {

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

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.naslov
        holder.clanak.text = model.clanak

        holder.binding.cardViewSport.setOnClickListener { v: View ->
            val data = SportTable(model.naslov,model.clanak)
            val action = SportFragmentDirections.actionSportNavDrawerToDetailSport(data)
            v.findNavController().navigate(action)
        }

    }

    class SportViewHolder(val binding: JedanRedSportBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}
