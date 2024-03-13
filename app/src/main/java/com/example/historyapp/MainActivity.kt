package com.example.historyapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.historyapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var ageMap = mapOf(
        21 to "n1",
        22 to "n2",
        33 to "n3",
        44 to "n4",
        55 to "n5",
        66 to "n6",
        77 to "n7",
        88 to "n8",
        98 to "n9",
        50 to "n10"
    )
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numInput = binding.numberEnt
        val entNum = binding.confirmGuess
        val clsNum = binding.clearGuess
        val txt = binding.displayHistory
        numInput.inputType = InputType.TYPE_CLASS_NUMBER

        entNum.setOnClickListener{
            val num = numInput.text.toString()
            val userAge = num.toIntOrNull()
            if (userAge != null){
                if (userAge < 20 || userAge > 100){
                    txt.text = "Please Enter A Number Between 20 and 100."
                } else{
                    disHistory(userAge, txt)
                }
            }else {
                txt.text = "Please Enter A Valid Number."
            }
        }
        clsNum.setOnClickListener {
            numInput.text.clear()
        }
    }
    @SuppressLint("SetTextI18n")
    private fun disHistory(age: Int, txt: TextView){
        if (ageMap.containsKey(age)){
            txt.text = "You are $age years old, which is the same age as ${ageMap[age]}. ${ageMap[age]} is a famous historical figure. "
        } else {
            txt.text = "There is no historical figure known to be around $age years old"
        }
    }
}