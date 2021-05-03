package Portal.adapter

import Portal.a257.databinding.JedanRedOglasnikBinding
import Portal.a257.databinding.JedanRedSportBinding
import Portal.database.table.OglasnikTable
import Portal.database.table.SportTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class OglasnikAdapter(options: FirestoreRecyclerOptions<OglasnikTable>) :
    FirestoreRecyclerAdapter<OglasnikTable, OglasnikAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            JedanRedOglasnikBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, model: OglasnikTable) {

        holder.naslov.text = model.oglasnikNaslov
        holder.clanak.text = model.oglasnikClanak
        holder.vrijeme.text = model.oglasnikVrijeme
        holder.broj.text = model.oglasnikBroj
        holder.lokacija.text = model.oglasnikLokacija
        holder.cijena.text = model.oglasnikCijena

    }

    class PersonViewHolder(val binding: JedanRedOglasnikBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
        var broj = binding.broj
        var lokacija = binding.lokacija
        var cijena = binding.cijena
    }
}