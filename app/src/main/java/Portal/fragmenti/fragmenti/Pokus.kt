package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.PokusFragmentBinding
import Portal.model.PokusTable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class Pokus: Fragment(R.layout.pokus_fragment) {

    private lateinit var binding: PokusFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PokusFragmentBinding.bind(view)

        binding.gumbSafeArgs.setOnClickListener {
            val ime = binding.editText1.text.toString()
            val prezime = binding.editText2.text.toString()
            val pokus = PokusTable(ime,prezime)
            val action = PokusDirections.actionMenuPokusToPokus2(pokus)
            findNavController().navigate(action)
        }
    }
}