package Portal.adapter


import Portal.a257.databinding.JedanRedZabavaBinding
import Portal.model.ZabavaTable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import java.text.SimpleDateFormat
import java.util.*

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
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.zabavaNaslov
        holder.clanak.text = model.zabavaClanak

    }

    class ZabavaViewHolder(val binding: JedanRedZabavaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var clanak = binding.clanak
        var vrijeme = binding.vrijeme
    }
}
