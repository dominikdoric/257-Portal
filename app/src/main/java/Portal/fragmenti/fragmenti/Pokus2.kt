package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.Pokus2FragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class Pokus2: Fragment(R.layout.pokus2_fragment) {

    private lateinit var binding: Pokus2FragmentBinding
    private val args by navArgs<Pokus2Args>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Pokus2FragmentBinding.bind(view)

        binding.textView1.text = args.pokusArgs.ime
        binding.textView2.text = args.pokusArgs.prezime
    }
}