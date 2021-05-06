package Portal.fragmenti.detail

import Portal.a257.R
import Portal.a257.databinding.DetailOglasnikBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailOglasnik: Fragment(R.layout.detail_oglasnik) {

    private lateinit var binding: DetailOglasnikBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailOglasnikBinding.bind(view)



    }
}