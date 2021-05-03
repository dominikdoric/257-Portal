package Portal.adapter

import Portal.a257.databinding.JedanRedPriceCitateljaBinding
import Portal.model.PriceCitateljaTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class PriceCitateljaAdapter(options: FirestoreRecyclerOptions<PriceCitateljaTable>) :
    FirestoreRecyclerAdapter<PriceCitateljaTable, PriceCitateljaAdapter.PersonViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            JedanRedPriceCitateljaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int, model: PriceCitateljaTable) {

        holder.naslov.text = model.priceCitateljaNaslov
        holder.clanak.text = model.priceCitateljaClanak
        holder.vrijeme.text = model.priceCitateljaVrijeme

    }

    class PersonViewHolder(val binding: JedanRedPriceCitateljaBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}