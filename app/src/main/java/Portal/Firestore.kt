package Portal

import Portal.a257.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.firestore.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class Firestore: AppCompatActivity() {

    private val personCollectionRef = Firebase.firestore.collection("persons")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firestore)

        btn_firestore.setOnClickListener {
            val firstName = firestore_firstName.text.toString()
            val lastName = firestore_lastName.text.toString()
            val age = firestore_age.text.toString().toInt()
            val person = Person(firstName, lastName, age)
            savePerson(person)
        }

        //subscribeToRealTimeUpdates()

        //btn_retrieveFirestore.setOnClickListener {
        //    retrievePersons()
        //}

    }

    private fun subscribeToRealTimeUpdates(){
        personCollectionRef.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            firebaseFirestoreException?.let {
                Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            querySnapshot?.let {
                val sb = StringBuilder()
                for(document in it){
                    val person = document.toObject<Person>()
                    sb.append("$person\n")
                }
                firestore_textView.text = sb.toString()
            }
        }
    }

    private fun retrievePersons() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = personCollectionRef.get().await()
            val sb = StringBuilder()
            for(document in querySnapshot.documents){
                val person = document.toObject<Person>()
                sb.append("$person\n")
            }
            withContext(Dispatchers.Main){
                firestore_textView.text = sb.toString()
            }
        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@Firestore,e.message,Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun savePerson(person: Person) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(person)
            withContext(Dispatchers.Main){
                Toast.makeText(this@Firestore,"Successfully saved data",Toast.LENGTH_LONG).show()
            }
        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@Firestore,e.message,Toast.LENGTH_LONG).show()
            }
        }
    }

}