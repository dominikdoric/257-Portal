package Portal.adapter

import Portal.a257.databinding.JedanRedPriceCitateljaBinding
import Portal.fragmenti.fragmenti.PriceCitateljaFragmentDirections
import Portal.model.PriceCitateljaTable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import java.text.SimpleDateFormat
import java.util.*

class PriceCitateljaAdapter(options: FirestoreRecyclerOptions<PriceCitateljaTable>) :
    FirestoreRecyclerAdapter<PriceCitateljaTable, PriceCitateljaAdapter.PriceCitateljaViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceCitateljaViewHolder {
        return PriceCitateljaViewHolder(
            JedanRedPriceCitateljaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PriceCitateljaViewHolder, position: Int, model: PriceCitateljaTable) {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        holder.vrijeme.text = currentDate
        holder.naslov.text = model.priceCitateljaNaslov

        holder.binding.cardViewPricaCitatelja.setOnClickListener { v: View ->
            val data = PriceCitateljaTable(model.priceCitateljaNaslov,model.priceCitateljaClanak)
            val action = PriceCitateljaFragmentDirections.actionPriceCitateljaNavDrawerToDetailPriceCitatelja(data)
            v.findNavController().navigate(action)
        }

    }

    class PriceCitateljaViewHolder(val binding: JedanRedPriceCitateljaBinding) : RecyclerView.ViewHolder(binding.root) {
        var naslov = binding.naslov
        var vrijeme = binding.vrijeme
    }
}