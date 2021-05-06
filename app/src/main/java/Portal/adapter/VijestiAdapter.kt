package Portal.adapter

import Portal.a257.databinding.JedanRedVijestiBinding
import Portal.fragmenti.fragmenti.VijestiFragmentDirections
import Portal.model.VijestiTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import java.text.SimpleDateFormat
import java.util.*

class VijestiAdapter(options: FirestoreRecyclerOptions<VijestiTable>) :
    FirestoreRecyclerAdapter<VijestiTable, VijestiAdapter.VijestiViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VijestiViewHolder {
        return VijestiViewHolder(
            JedanRedVijestiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VijestiViewHolder, position: Int, model: VijestiTable) {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.vijestiNaslov
        holder.clanak.text = model.vijestiClanak

        holder.binding.cardViewVijesti.setOnClickListener { v: View ->
            val data = VijestiTable(model.vijestiNaslov,model.vijestiClanak)
            val action = VijestiFragmentDirections.actionVijestiNavDrawerToVijestiDetail(data)
            v.findNavController().navigate(action)
        }

    }

    class VijestiViewHolder(val binding: JedanRedVijestiBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}


