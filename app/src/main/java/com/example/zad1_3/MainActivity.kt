package com.example.zad1_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    var divisionOperation = false
    var addOperation = false
    var subOperation = false
    var multiOperation = false
    var percentOperation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val percent = findViewById<Button>(R.id.button1)
        val ce = findViewById<Button>(R.id.button2)
        val c = findViewById<Button>(R.id.button3)
        val bckp = findViewById<Button>(R.id.button4)
        val divison = findViewById<Button>(R.id.button5)
        val power = findViewById<Button>(R.id.button6)
        val sqrt = findViewById<Button>(R.id.button7)
        val divide = findViewById<Button>(R.id.button8)
        val seven = findViewById<Button>(R.id.button9)
        val eight = findViewById<Button>(R.id.button10)
        val nine = findViewById<Button>(R.id.button11)
        val multi = findViewById<Button>(R.id.button12)
        val four = findViewById<Button>(R.id.button13)
        val five = findViewById<Button>(R.id.button14)
        val six = findViewById<Button>(R.id.button15)
        val sub = findViewById<Button>(R.id.button16)
        val one = findViewById<Button>(R.id.button17)
        val two = findViewById<Button>(R.id.button18)
        val three = findViewById<Button>(R.id.button19)
        val add = findViewById<Button>(R.id.button20)
        val negative = findViewById<Button>(R.id.button21)
        val zero = findViewById<Button>(R.id.button22)
        val dot = findViewById<Button>(R.id.button23)
        val equal = findViewById<Button>(R.id.button24)
        val textView = findViewById<TextView>(R.id.textView)
        val textViewMemory = findViewById<TextView>(R.id.textViewMemory)
        val textViewSymbol = findViewById<TextView>(R.id.textViewSymbol)
        textView.movementMethod = ScrollingMovementMethod()
        textViewMemory.movementMethod = ScrollingMovementMethod()

        one.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("1")
        }
        two.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("2")
        }
        three.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("3")
        }
        four.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("4")
        }
        five.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("5")
        }
        six.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("6")
        }
        seven.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("7")
        }
        eight.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("8")
        }
        nine.setOnClickListener {
            checkIfZero()
            textView.text = textView.text.toString().plus("9")
        }
        zero.setOnClickListener {
            textView.text = textView.text.toString().plus("0")
        }
        ce.setOnClickListener {
            textView.text = ""
            textViewMemory.text = ""
            textViewSymbol.text = ""
            checkIfEmpty()
            divisionOperation = false
            addOperation = false
            subOperation = false
            multiOperation = false
            percentOperation = false
        }
        c.setOnClickListener {
            textView.text = ""
            checkIfEmpty()
        }
        bckp.setOnClickListener {
            if(textView.length()>0) textView.text = textView.text.subSequence(0,textView.length()-1)
            if(textView.text.contains("Infinit")) textView.text = ""
            checkIfEmpty()
        }
        dot.setOnClickListener{
            if(!textView.text.contains(".")) textView.text = textView.text.toString().plus(".")
        }
        negative.setOnClickListener {
            textView.text = (textView.text.toString().toDouble() * (-1.0)).toString()
        }
        divison.setOnClickListener {
            if(textView.text.toString().toDouble() != 0.0) textView.text = (1.0 / textView.text.toString().toDouble()).toString()
        }
        power.setOnClickListener {
            textView.text = (textView.text.toString().toDouble()*textView.text.toString().toDouble()).toString()
        }
        sqrt.setOnClickListener {
            textView.text = (sqrt(textView.text.toString().toDouble())).toString()
        }
        divide.setOnClickListener {
            doMath()
            textViewMemory.text = textView.text.toString()
            textView.text = "0"
            textViewSymbol.text = " ÷"
            divisionOperation = true
        }
        add.setOnClickListener {
            doMath()
            textViewMemory.text = textView.text.toString()
            textView.text = "0"
            textViewSymbol.text = " +"
            addOperation = true
        }
        sub.setOnClickListener {
            doMath()
            textViewMemory.text = textView.text.toString()
            textView.text = "0"
            textViewSymbol.text = " -"
            subOperation = true
        }
        multi.setOnClickListener {
            doMath()
            textViewMemory.text = textView.text.toString()
            textView.text = "0"
            textViewSymbol.text = " X"
            multiOperation = true
        }
        percent.setOnClickListener{
            doMath()
            textViewMemory.text = textView.text.toString()
            textView.text = "0"
            textViewSymbol.text = " %"
            percentOperation = true
        }
        equal.setOnClickListener {
            doMath()
        }
    }
    fun checkIfEmpty(){
        val textView = findViewById<TextView>(R.id.textView)
        if(textView.text.toString()=="") textView.text="0"
    }

    fun checkIfZero(){
        val textView = findViewById<TextView>(R.id.textView)
        if(textView.text.toString()=="0") textView.text=""
    }

    fun doMath(){
        val textView = findViewById<TextView>(R.id.textView)
        val textViewMemory = findViewById<TextView>(R.id.textViewMemory)
        val textViewSymbol = findViewById<TextView>(R.id.textViewSymbol)

        if(divisionOperation && textView.text.toString()!="0"){
            divisionOperation = false
            textView.text = (textViewMemory.text.toString().toDouble() / textView.text.toString().toDouble()).toString()
            textViewMemory.text = ""
            textViewSymbol.text = ""
        }
        else if(addOperation){
            addOperation = false
            textView.text = (textViewMemory.text.toString().toDouble() + textView.text.toString().toDouble()).toString()
            textViewMemory.text = ""
            textViewSymbol.text = ""
        }
        else if(subOperation){
            subOperation = false
            textView.text = (textViewMemory.text.toString().toDouble() - textView.text.toString().toDouble()).toString()
            textViewMemory.text = ""
            textViewSymbol.text = ""
        }
        else if(multiOperation){
            multiOperation = false
            textView.text = (textViewMemory.text.toString().toDouble() * textView.text.toString().toDouble()).toString()
            textViewMemory.text = ""
            textViewSymbol.text = ""
        }
        else if(percentOperation){
            percentOperation = false
            textView.text = (textViewMemory.text.toString().toDouble() * (textView.text.toString().toDouble() / 100)).toString()
            textViewMemory.text = ""
            textViewSymbol.text = ""
        }

    }

}