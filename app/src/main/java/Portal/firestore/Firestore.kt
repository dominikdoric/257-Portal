package Portal.firestore

import Portal.a257.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.SetOptions
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

    private val personCollectionRef = Firebase.firestore.collection("sport")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firestore)

        btn_saveFirestore.setOnClickListener {
            val sport = getOldPerson()
            savePerson(sport)
        }

        //subscribeToRealTimeUpdates()

    }

    private fun getOldPerson(): SportModel {
        val naslov = firestore_naslov.text.toString()
        val clanak = firestore_clanak.text.toString()
        val vrijeme = firestore_vrijeme.text.toString()
        val slika = 1
        return SportModel(naslov,clanak,vrijeme,slika)
    }

    private fun deletePerson(person: Person) = CoroutineScope(Dispatchers.IO).launch {
        val personQuery = personCollectionRef
            .whereEqualTo("firstName",person.firstName)
            .whereEqualTo("lastName",person.lastName)
            .whereEqualTo("age",person.age)
            .get()
            .await()
        if (personQuery.documents.isNotEmpty()){
            for(document in personQuery){
                try {
                    personCollectionRef.document(document.id).delete().await()
                    //personCollectionRef.document(document.id).update(mapOf(
                    //    "firstName" to FieldValue.delete()
                    //))
                }catch (e: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Firestore,e.message,
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }else{
            withContext(Dispatchers.Main){
                Toast.makeText(this@Firestore,"No person matched to query",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun updatePerson(person: Person, newPersonMap: Map<String,Any>) = CoroutineScope(Dispatchers.IO).launch {
        val personQuery = personCollectionRef
            .whereEqualTo("firstName",person.firstName)
            .whereEqualTo("lastName",person.lastName)
            .whereEqualTo("age",person.age)
            .get()
            .await()
        if (personQuery.documents.isNotEmpty()){
            for(document in personQuery){
                try {
                    personCollectionRef.document(document.id).set(
                        newPersonMap,
                        SetOptions.merge()
                    ).await()
                }catch (e: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Firestore,e.message,
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }else{
            withContext(Dispatchers.Main){
                Toast.makeText(this@Firestore,"No person matched to query",
                Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun birthday(personId: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            Firebase.firestore.runTransaction { transaction ->
                val personRef = personCollectionRef.document(personId)
                val person = transaction.get(personRef)
                val newAge = person["age"] as Long + 1
                transaction.update(personRef,"age",newAge)
                null
            }.await()
        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@Firestore,e.message,Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun changeName(personId: String,newFirstName: String, newLastName: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            Firebase.firestore.runBatch { batch ->
                val personRef = personCollectionRef.document(personId)
                batch.update(personRef, "firstName",newFirstName)
                batch.update(personRef,"lastName",newLastName)
            }.await()
        }catch (e: Exception){
           withContext(Dispatchers.Main){
               Toast.makeText(this@Firestore,e.message,Toast.LENGTH_LONG).show()
           }
        }
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

    private fun savePerson(sport: SportModel) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(sport)
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