package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteOglasnikBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class UpdateDeleteOglasnik: Fragment(R.layout.update_delete_oglasnik) {

    private lateinit var binding: UpdateDeleteOglasnikBinding
    private val args by navArgs<UpdateDeleteOglasnikArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteOglasnikBinding.bind(view)

        binding.naslov.setText(args.updateOglasnikArgs.oglasnikNaslov)
        binding.clanak.setText(args.updateOglasnikArgs.oglasnikClanak)
        binding.cijena.setText(args.updateOglasnikArgs.oglasnikCijena)
        binding.lokacija.setText(args.updateOglasnikArgs.oglasnikLokacija)
        binding.broj.setText(args.updateOglasnikArgs.oglasnikBroj)

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