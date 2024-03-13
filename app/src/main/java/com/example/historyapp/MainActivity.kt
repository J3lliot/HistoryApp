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
        20 to "Agatha of sicily",
        28 to "Heath Ledger",
        36 to "Bob Marley",
        44 to "Pablo Escobar",
        52 to "Grace Kelly",
        60 to "Theodore Roosevelt",
        68 to "Rita Hayworth",
        76 to "Albert Einstein",
        84 to "Benjamin Franklin",
        92 to "Rosa Parks"
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
            txt.text = ""
        }
    }
    @SuppressLint("SetTextI18n")
    private fun disHistory(age: Int, txt: TextView){
        if (ageMap.containsKey(age)){
            txt.text = "You are $age years old, which is the same age as ${ageMap[age]}. ${ageMap[age]} is a famous figure. "
        } else {
            txt.text = "There is no person that matches $age years old"
        }
    }
}