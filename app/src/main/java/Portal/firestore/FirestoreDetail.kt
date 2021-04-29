package Portal.firestore

import Portal.a257.R
import Portal.a257.databinding.FirestoreDetailBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class FirestoreDetail : Fragment(R.layout.firestore_detail) {

    private val args by navArgs<FirestoreDetailArgs>()
    private lateinit var binding: FirestoreDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FirestoreDetailBinding.bind(view)

        binding.firestoreDetailFirstName.text = args.firestoreArgs.firstName
        binding.firestoreDetailLastName.text = args.firestoreArgs.lastName
        binding.firestoreDetailAge.text = args.firestoreArgs.age.toString()

    }
}