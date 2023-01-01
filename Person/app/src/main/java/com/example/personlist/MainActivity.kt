package com.example.personlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.personlist.databinding.ActivityMainBinding
import java.io.Serializable

data class Person(var name :String , var age:Int ):Serializable
var TAG = "App"
class MainActivity : AppCompatActivity() {
//    var REQUEST_CODE =89
    var contacts= mutableListOf<Person>()
    private  val getResult= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
        Log.i(TAG, "Data is reverted back to mai  activity ")
        var person = result.data?.getSerializableExtra("EXTRA_PERSON") as Person
        processResult(result.resultCode,person)
        Log.i(TAG, "Data is reverted back to mai  activity 1")
    }

    companion object {

    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        val data = binding.root
        super.onCreate(savedInstanceState)
        setContentView(data)

        contacts = getcontaccts()
        binding.rvContacts.adapter= ContactsAdapter(contacts,this)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.i(TAG, "onCreateOptionsMenu: ")
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i(TAG, "onOptionsItemSelected: ")
        if(item.itemId==R.id.mi_add){
            //this is depracted :((
            val intent = Intent(this,MainActivity2::class.java)
//            startActivityForResult(intent, REQUEST_CODE)
            getResult.launch(intent)
            Log.i(TAG, "started activity under on option item selected  ")
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        processResult( resultCode, data)
//
//


    private fun processResult(
        resultCode: Int,
person: Person
    ) {
        if (resultCode == Activity.RESULT_OK) {
            Log.i(TAG, "Contacts size before ${contacts.size}")

            contacts.add(person)
            Log.i(TAG, "Contacts size after ${contacts.size}")
            ContactsAdapter(contacts, this).notifyDataSetChanged()
            Log.i(TAG, "processResult: ${contacts[100]}")

        }
    }


    private fun getcontaccts(): MutableList<Person> {
          var list= mutableListOf<Person>()
        for(i in 1 .. 100){
            list.add(Person("Person $i ",i))
        }
        return  list
    }
}