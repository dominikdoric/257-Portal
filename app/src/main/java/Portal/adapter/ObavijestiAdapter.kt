package Portal.adapter

import Portal.MainActivity
import Portal.a257.databinding.JedanRedObavijestiBinding
import Portal.fragmenti.fragmenti.ObavijestiFragmentDirections
import Portal.model.ObavijestiTable
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

class ObavijestiAdapter(options: FirestoreRecyclerOptions<ObavijestiTable>) :
    FirestoreRecyclerAdapter<ObavijestiTable, ObavijestiAdapter.ObavijestiViewHolder>(options) {

    private lateinit var auth: FirebaseAuth

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObavijestiViewHolder {
        return ObavijestiViewHolder(
            JedanRedObavijestiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ObavijestiViewHolder, position: Int, model: ObavijestiTable) {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())
        auth = FirebaseAuth.getInstance()

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.obavijestiNaslov

        holder.binding.cardViewObavijesti.setOnClickListener { v: View ->
            val data = ObavijestiTable(model.obavijestiNaslov,model.obavijestiClanak)
            val action = ObavijestiFragmentDirections.actionObavijestiNavDrawerToObavijestiDetail(data)
            v.findNavController().navigate(action)

            if (v.context is MainActivity){
                (v.context as MainActivity?)?.hideBottomNavigationView()
            }
        }

        if (auth.currentUser != null) {
            holder.binding.cardViewObavijesti.setOnLongClickListener { v: View ->
                val data = ObavijestiTable(model.obavijestiNaslov, model.obavijestiClanak)
                val action =
                    ObavijestiFragmentDirections.actionObavijestiNavDrawerToUpdateDeleteObavijesti(
                        data
                    )
                v.findNavController().navigate(action)
                true
            }
        }
    }

    class ObavijestiViewHolder(val binding: JedanRedObavijestiBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var vrijeme = binding.vrijeme
    }
}