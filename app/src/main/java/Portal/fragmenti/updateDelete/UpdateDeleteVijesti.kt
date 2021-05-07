package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteVijestiBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class UpdateDeleteVijesti: Fragment(R.layout.update_delete_vijesti) {

    private lateinit var binding: UpdateDeleteVijestiBinding
    private val args by navArgs<UpdateDeleteVijestiArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteVijestiBinding.bind(view)

        binding.naslov.setText(args.updateVijestiArgs.vijestiNaslov)
        binding.clanak.setText(args.updateVijestiArgs.vijestiClanak)

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