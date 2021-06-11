package Portal.adapter

import Portal.MainActivity
import Portal.a257.databinding.JedanRedVijestiBinding
import Portal.fragmenti.fragmenti.VijestiFragmentDirections
import Portal.model.VijestiTable
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

class VijestiAdapter(options: FirestoreRecyclerOptions<VijestiTable>) :
    FirestoreRecyclerAdapter<VijestiTable, VijestiAdapter.VijestiViewHolder>(options) {

    private lateinit var auth: FirebaseAuth

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VijestiViewHolder {
        return VijestiViewHolder(
            JedanRedVijestiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: VijestiViewHolder, position: Int, model: VijestiTable) {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())
        auth = FirebaseAuth.getInstance()

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.vijestiNaslov

        holder.binding.cardViewVijesti.setOnClickListener { v: View ->
            val data = VijestiTable(model.vijestiNaslov,model.vijestiClanak)
            val action = VijestiFragmentDirections.actionVijestiNavDrawerToVijestiDetail(data)
            v.findNavController().navigate(action)

            if (v.context is MainActivity){
                (v.context as MainActivity?)?.hideBottomNavigationView()
            }
        }

        if (auth.currentUser != null) {
            holder.binding.cardViewVijesti.setOnLongClickListener { v: View ->
                val data = VijestiTable(model.vijestiNaslov, model.vijestiClanak)
                val action =
                    VijestiFragmentDirections.actionVijestiNavDrawerToUpdateDeleteVijesti(data)
                v.findNavController().navigate(action)
                true
            }
        }
    }

    class VijestiViewHolder(val binding: JedanRedVijestiBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var vrijeme = binding.vrijeme
    }
}


