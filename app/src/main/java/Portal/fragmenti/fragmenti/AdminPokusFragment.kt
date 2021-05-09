package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.AdminPokusFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdminPokusFragment: Fragment(R.layout.admin_pokus_fragment) {

    private lateinit var binding: AdminPokusFragmentBinding
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPokusFragmentBinding.bind(view)
        auth = FirebaseAuth.getInstance()



    }

    private fun registerUser(){
        val email = binding.email.text.toString()
        val lozinka = binding.lozinka.text.toString()
        if (email.isNotEmpty() && lozinka.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try {

                }catch (e: Exception){

                }
            }
        }
    }
}