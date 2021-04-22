package Portal.firestore

import Portal.a257.R
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_authentication.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.net.URI

class Authentication : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        auth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener {
            registerUser()
        }

        btnLogin.setOnClickListener {
            loginUser()
        }

        btnUpdateProfile.setOnClickListener {
            updateProfil()
        }

    }

    override fun onStart() {
        super.onStart()
        checkLoggedInState()
    }

    private fun updateProfil(){
        auth.currentUser?.let { user ->
            val userName = etUsername.text.toString()
            val photoURI = Uri.parse("android.resource:///$packageName/${R.drawable.jaksic}")
            val profileUpdate = UserProfileChangeRequest.Builder()
                .setDisplayName(userName)
                .setPhotoUri(photoURI)
                .build()
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    user.updateProfile(profileUpdate).await()
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Authentication,"Successfully updated",Toast.LENGTH_LONG).show()
                    }
                }catch (e: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Authentication,e.message,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun registerUser(){
        val email = etEmailRegister.text.toString()
        val password = etPasswordRegister.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.createUserWithEmailAndPassword(email, password).await()
                    withContext(Dispatchers.Main){
                        checkLoggedInState()
                    }
                }catch (e: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Authentication,e.message,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun loginUser(){
        val email = etEmailLogin.text.toString()
        val password = etPasswordLogin.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.signInWithEmailAndPassword(email, password).await()
                    withContext(Dispatchers.Main){
                        checkLoggedInState()
                    }
                }catch (e: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Authentication,e.message,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun checkLoggedInState() {
        if (auth.currentUser == null){
            tvLoggedIn.text = "You are not logged in"
        }else{
            tvLoggedIn.text = "You are logged in"
        }
    }
}