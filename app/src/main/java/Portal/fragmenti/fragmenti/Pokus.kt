package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.PokusFragmentBinding
import Portal.model.PokusTable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Pokus: Fragment(R.layout.pokus_fragment) {

    private lateinit var binding: PokusFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PokusFragmentBinding.bind(view)

        val pokus = PokusTable("Dominik","Doric")

        binding.gumbSafeArgs.setOnClickListener {
            val action = PokusDirections.actionMenuPokusToPokus2(pokus)
            findNavController().navigate(action)
        }
    }

}