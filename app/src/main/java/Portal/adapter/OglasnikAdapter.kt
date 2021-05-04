package Portal.adapter

import Portal.a257.databinding.JedanRedOglasnikBinding
import Portal.model.OglasnikTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

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

    override fun onBindViewHolder(holder: OglasnikViewHolder, position: Int, model: OglasnikTable) {

        holder.naslov.text = model.oglasnikNaslov
        holder.clanak.text = model.oglasnikClanak
        holder.vrijeme.text = model.oglasnikVrijeme
        holder.broj.text = model.oglasnikBroj
        holder.lokacija.text = model.oglasnikLokacija
        holder.cijena.text = model.oglasnikCijena

    }

    class OglasnikViewHolder(val binding: JedanRedOglasnikBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
        var broj = binding.broj
        var lokacija = binding.lokacija
        var cijena = binding.cijena
    }
}