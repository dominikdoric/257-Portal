package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.CloudStorageFirebaseBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class CloudStorageFragment: Fragment(R.layout.cloud_storage_firebase) {

    private lateinit var binding: CloudStorageFirebaseBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CloudStorageFirebaseBinding.bind(view)
    }

}