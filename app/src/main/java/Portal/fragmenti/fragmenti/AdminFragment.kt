package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.AdminFragmentBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AdminFragment: Fragment(R.layout.admin_fragment) {

    private lateinit var binding: AdminFragmentBinding
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminFragmentBinding.bind(view)
        auth = FirebaseAuth.getInstance()

        binding.btnPrijaviSe.setOnClickListener {
            registerUser()
        }

        binding.btnOdjaviSe.setOnClickListener {
            auth.signOut()
            checkLoggedInState()
        }
    }

    override fun onStart() {
        super.onStart()
        checkLoggedInState()
    }

    private fun registerUser(){
        val email = binding.email.text.toString()
        val lozinka = binding.lozinka.text.toString()
        if (email.isNotEmpty() && lozinka.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.signInWithEmailAndPassword(email,lozinka).await()
                    withContext(Dispatchers.Main){
                        checkLoggedInState()
                    }

                }catch (e: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(requireContext(),e.message,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun checkLoggedInState() {
        if (auth.currentUser == null){
            binding.textView.text = "Niste prijavljeni!"
        }else{
            binding.textView.text = "Prijavljeni ste!"
        }
    }
}