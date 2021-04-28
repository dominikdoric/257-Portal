package Portal.firestore

import Portal.a257.R
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class FirestoreFragment: Fragment(R.layout.firestore_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("persons")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun savePerson(person: Person) = CoroutineScope(Dispatchers.IO).launch{
        try {

        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(requireContext(),e.message,Toast.LENGTH_LONG).show()
            }
        }
    }

}