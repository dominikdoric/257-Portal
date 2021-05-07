package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteSportBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class UpdateDeleteSport: Fragment(R.layout.update_delete_sport) {

    private lateinit var binding: UpdateDeleteSportBinding
    private val args by navArgs<UpdateDeleteSportArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteSportBinding.bind(view)

        binding.naslov.setText(args.updateSportArgs.naslov)
        binding.clanak.setText(args.updateSportArgs.clanak)

        binding.gumbAzuriraj.setOnClickListener {
            updateItem()
        }

        binding.gumbObrisi.setOnClickListener {
            deleteItem()
        }

    }

    private fun deleteItem() {

    }

    private fun updateItem() {

    }

}