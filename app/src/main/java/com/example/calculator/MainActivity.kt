package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var tvinput:TextView?=null
    private var lastDigit=false
    private var lastpoint=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvinput=findViewById(R.id.tvinput)
    }
    fun onDigit(view: View){
        tvinput?.append((view as Button).text)
        lastDigit=true

    }
    fun onClear(view:View){
        tvinput?.text=""
        lastDigit=false
        lastpoint=false
    }
    fun onDecimal(view:View){
        if(lastDigit && !lastpoint){
            tvinput?.append(".")
            lastpoint=true
            lastDigit=false
        }
    }
    fun onOperator(view:View){

        if(lastDigit && !isOperatorAdded(tvinput?.text.toString())){
            tvinput?.append((view as Button).text)
            lastDigit=false
            lastpoint=false
        }

    }
    fun onEqual(view:View) {
        if (lastDigit) {
            var tvValue = tvinput?.text.toString()
            var prefix: String = ""
            var value = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    value = tvValue.substring(1)
                }
                if (tvValue.contains("-")) {
                    if (prefix.isNotEmpty()) {
                        var splitValue = tvValue?.split("-")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        one = prefix + one
                        tvinput?.text = (one.toDouble() - two.toDouble()).toString()

                    } else {
                        var splitValue = tvValue?.split("-")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        var ans = (one.toDouble() - two.toDouble()).toString()
                        tvinput?.text = ans
                    }
                } else if (tvValue.contains("/")) {
                    if (prefix.isNotEmpty()) {
                        var splitValue = tvValue?.split("/")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        one = prefix + one
                        tvinput?.text = (one.toDouble() / two.toDouble()).toString()

                    } else {
                        var splitValue = tvValue?.split("/")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        var ans = (one.toDouble() / two.toDouble()).toString()
                        tvinput?.text = ans
                    }
                } else if (tvValue.contains("*")) {
                    if (prefix.isNotEmpty()) {
                        var splitValue = tvValue?.split("*")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        one = prefix + one
                        tvinput?.text = (one.toDouble() * two.toDouble()).toString()

                    } else {
                        var splitValue = tvValue?.split("*")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        var ans = (one.toDouble() * two.toDouble()).toString()
                        tvinput?.text = ans
                    }
                } else if (tvValue.contains("+")) {
                    if (prefix.isNotEmpty()) {
                        var splitValue = tvValue?.split("+")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        one = prefix + one
                        tvinput?.text = (one.toDouble() + two.toDouble()).toString()

                    } else {
                        var splitValue = tvValue?.split("+")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        var ans = (one.toDouble() + two.toDouble()).toString()
                        tvinput?.text = ans
                    }
                }
            }catch(e:ArithmeticException){
                e.printStackTrace()
            }
        }
    }
    private fun isOperatorAdded(value:String):Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            (value.contains("/")||value.contains("*")||value.contains("-")||value.contains("+"))
        }
    }
}