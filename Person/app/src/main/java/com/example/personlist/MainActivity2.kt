package com.example.personlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.personlist.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding2: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityMain2Binding.inflate(layoutInflater)
        var data = binding2.root
        setContentView(data)
        binding2.button.setOnClickListener{
            var name = binding2.etName.text.toString()
            var age = binding2.etAge.text.toString().toInt()
            var result = Intent()
            Log.i(TAG, "onCreate: $name $age ")
            result.putExtra("EXTRA_PERSON",Person(name,age))
            setResult(Activity.RESULT_OK,result)
            finish()
        }
    }
}