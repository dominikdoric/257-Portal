package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteObavijestiBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class UpdateDeleteObavijesti: Fragment(R.layout.update_delete_obavijesti) {

    private lateinit var binding: UpdateDeleteObavijestiBinding
    private val args by navArgs<UpdateDeleteObavijestiArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteObavijestiBinding.bind(view)

        binding.naslov.setText(args.updateObavijestiArgs.obavijestiNaslov)
        binding.clanak.setText(args.updateObavijestiArgs.obavijestiClanak)

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