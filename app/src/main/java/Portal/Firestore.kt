package Portal

import Portal.a257.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FieldValue
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

    private val personCollectionRef = Firebase.firestore.collection("persons")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firestore)

        btn_saveFirestore.setOnClickListener {
            val person = getOldPerson()
            savePerson(person)
        }

        //subscribeToRealTimeUpdates()

        btn_retrieveFirestore.setOnClickListener {
            retrievePersons()
        }

        btn_updateFirestore.setOnClickListener {
            val oldPerson = getOldPerson()
            val newPersonMap = getNewPersonMap()
            updatePerson(oldPerson,newPersonMap)
        }

        btn_deleteFirestore.setOnClickListener {
            val person = getOldPerson()
            deletePerson(person)
        }

        btn_batchedFirestore.setOnClickListener {
            changeName("778c5nhEMfjzJ6zdAvM4","Elon","Musk")
        }

    }

    private fun getOldPerson(): Person{
        val firstName = firestore_firstName.text.toString()
        val lastName = firestore_lastName.text.toString()
        val age = firestore_age.text.toString().toInt()
        return Person(firstName, lastName, age)
    }

    private fun getNewPersonMap(): Map<String,Any>{
        val firstName = firestore_firstNameUpdate.text.toString()
        val lastName = firestore_lastNameUpdate.text.toString()
        val age = firestore_ageUpdate.text.toString()
        val map = mutableMapOf<String,Any>()
        if (firstName.isNotEmpty()){
            map["firstName"] = firstName
        }
        if (lastName.isNotEmpty()){
            map["lastName"] = lastName
        }
        if (age.isNotEmpty()){
            map["age"] = age.toInt()
        }
        return map
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

    private fun retrievePersons() = CoroutineScope(Dispatchers.IO).launch {
        val fromAge = et_od.text.toString().toInt()
        val toAge = et_do.text.toString().toInt()
        try {
            //val querySnapshot = personCollectionRef.get().await()
            val querySnapshot = personCollectionRef
                .whereGreaterThan("age",fromAge)
                .whereLessThan("age",toAge)
                .orderBy("age")
                .get()
                .await()
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