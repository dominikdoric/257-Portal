package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.CloudStorageFirebaseBinding
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

private const val REQUEST_CODE_IMAGE_PICK = 0

class CloudStorageFragment: Fragment(R.layout.cloud_storage_firebase) {

    private lateinit var binding: CloudStorageFirebaseBinding
    val imageRef = Firebase.storage.reference
    var curFile: Uri? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CloudStorageFirebaseBinding.bind(view)

        binding.storageSlika.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }

        binding.gumbStorage.setOnClickListener {
            uploadImageToStorage("myImage")
        }
    }

    private fun uploadImageToStorage(filename: String) = CoroutineScope(Dispatchers.IO).launch{
        try {
            curFile?.let {
                imageRef.child("images/$filename").putFile(it).await()
                withContext(Dispatchers.Main){
                    Toast.makeText(requireContext(),"Successfully uploaded image",Toast.LENGTH_LONG).show()
                }
            }
        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(requireContext(),e.message,Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK){
            data?.data?.let {
                curFile = it
                binding.storageSlika.setImageURI(it)
            }
        }
    }

}