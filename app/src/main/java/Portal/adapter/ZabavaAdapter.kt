package Portal.adapter


import Portal.a257.databinding.JedanRedZabavaBinding
import Portal.model.ZabavaTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class ZabavaAdapter(options: FirestoreRecyclerOptions<ZabavaTable>) :
    FirestoreRecyclerAdapter<ZabavaTable, ZabavaAdapter.ZabavaViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZabavaViewHolder {
        return ZabavaViewHolder(
            JedanRedZabavaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ZabavaViewHolder, position: Int, model: ZabavaTable) {

        holder.naslov.text = model.zabavaNaslov
        holder.clanak.text = model.zabavaClanak
        holder.vrijeme.text = model.zabavaVrijeme

    }

    class ZabavaViewHolder(val binding: JedanRedZabavaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}
