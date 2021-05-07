package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeletePoljoprivredaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class UpdateDeletePoljoprivreda: Fragment(R.layout.update_delete_poljoprivreda) {

    private lateinit var binding: UpdateDeletePoljoprivredaBinding
    private val args by navArgs<UpdateDeletePoljoprivredaArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeletePoljoprivredaBinding.bind(view)

        binding.naslov.setText(args.poljoprivredaUpdateArgs.poljoprivredaNaslov)
        binding.clanak.setText(args.poljoprivredaUpdateArgs.poljoprivredaClanak)

        binding.gumbAzuriraj.setOnClickListener {
            azurirajItem()
        }

        binding.gumbObrisi.setOnClickListener {
            obrisiItem()
        }
    }

    private fun obrisiItem() {

    }

    private fun azurirajItem() {

    }

}