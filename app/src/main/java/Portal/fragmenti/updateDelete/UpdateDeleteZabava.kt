package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteZabavaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class UpdateDeleteZabava: Fragment(R.layout.update_delete_zabava) {

    private lateinit var binding: UpdateDeleteZabavaBinding
    private val args by navArgs<UpdateDeleteZabavaArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteZabavaBinding.bind(view)

        binding.naslov.setText(args.updateZabavaArgs.zabavaNaslov)
        binding.clanak.setText(args.updateZabavaArgs.zabavaClanak)

        binding.gumbAzuriraj.setOnClickListener { v: View ->
            azurirajItem()
        }

        binding.gumbObrisi.setOnClickListener { v: View ->
            obrisiItem()
        }

    }

    private fun obrisiItem() {

    }

    private fun azurirajItem() {

    }

}