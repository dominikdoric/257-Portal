package Portal.adapter

import Portal.a257.databinding.JedanRedOglasnikBinding
import Portal.fragmenti.fragmenti.OglasnikFragmentDirections
import Portal.model.OglasnikTable
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import java.text.SimpleDateFormat
import java.util.*

class OglasnikAdapter(options: FirestoreRecyclerOptions<OglasnikTable>) :
    FirestoreRecyclerAdapter<OglasnikTable, OglasnikAdapter.OglasnikViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OglasnikViewHolder {
        return OglasnikViewHolder(
            JedanRedOglasnikBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: OglasnikViewHolder, position: Int, model: OglasnikTable) {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.oglasnikNaslov
        holder.broj.text = model.oglasnikBroj
        holder.lokacija.text = model.oglasnikLokacija
        holder.cijena.text = model.oglasnikCijena

        holder.binding.cardViewOglasnik.setOnClickListener { v: View ->
            val data = OglasnikTable(model.oglasnikClanak,model.oglasnikNaslov,model.oglasnikCijena,model.oglasnikLokacija,model.oglasnikBroj)
            val action = OglasnikFragmentDirections.actionOglasnikNavDrawerToDetailOglasnik(data)
            v.findNavController().navigate(action)
        }

    }

    class OglasnikViewHolder(val binding: JedanRedOglasnikBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var vrijeme = binding.vrijeme
        var broj = binding.broj
        var lokacija = binding.lokacija
        var cijena = binding.cijena
    }
}