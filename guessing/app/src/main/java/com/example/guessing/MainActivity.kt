package com.example.guessing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.guessing.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        var bound = binding.root
        super.onCreate(savedInstanceState)
        setContentView(bound)
        binding.uppertv.setTextColor(Color.BLACK)


        binding.leftbtn.apply {
            setOnClickListener{
                val left = binding.leftbtn.text.toString().toInt()
                val right = binding.rightbtn.text.toString().toInt()
            if (left > right) {
                binding.layoutt.setBackgroundColor(Color.GREEN)
                Toast.makeText(binding.leftbtn.context, "you are correct", Toast.LENGTH_SHORT).show()
               changeValue()
            }
            else {
                binding.layoutt.setBackgroundColor(Color.RED)
                Toast.makeText(this.context, "incorrect", Toast.LENGTH_SHORT).show()
              changeValue()
            }}
        }

        binding.rightbtn.apply {
            setOnClickListener{
                val left = binding.leftbtn.text.toString().toInt()
                val right = binding.rightbtn.text.toString().toInt()
            if(right>left){
                binding.layoutt.setBackgroundColor(Color.GREEN)
                Toast.makeText(this.context, "Correct", Toast.LENGTH_SHORT).show()
               changeValue()
            }
            else{
                binding.layoutt.setBackgroundColor(Color.RED)
                Toast.makeText(this.context, "Incorrect", Toast.LENGTH_SHORT).show()
               changeValue()
            }}
        }
    }

    private fun changeValue() {
val r = Random()
        val left=r.nextInt(20)
        var right=r.nextInt(20)
        while (left==right){
            right=r.nextInt(20)
        }
        binding.rightbtn.text=right.toString()
        binding.leftbtn.text=left.toString()
    }
}