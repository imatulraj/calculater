package com.gupta.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun BUTEvent(view: View) {
        val butSelect=view as Button

        var ButValue:String=""
        when(butSelect.id){
        but0.id ->{
            ButValue=ShowResult.text.toString()+"0"
        }
            but0.id ->{
                ButValue=ShowResult.text.toString()+"0"
            }
            but1.id ->{
                ButValue=ShowResult.text.toString()+"1"
            }
            but2.id ->{
                ButValue=ShowResult.text.toString()+"2"
            }
            but3.id ->{
                ButValue=ShowResult.text.toString()+"3"
            }
            but4.id ->{
                ButValue=ShowResult.text.toString()+"4"
            }
            but5.id ->{
                ButValue=ShowResult.text.toString()+"5"
            }
            but6.id ->{
                ButValue=ShowResult.text.toString()+"6"
            }
            but7.id ->{
                ButValue=ShowResult.text.toString()+"7"
            }
            but8.id ->{
                ButValue=ShowResult.text.toString()+"8"
            }
            butac.id ->{

                ButValue=""
            }
            butDot.id ->{
                if(ShowResult.text.toString().contains("."))
                {ButValue=ShowResult.text.toString()}
                else
                {ButValue=ShowResult.text.toString()+"."}
            }
            but9.id ->{
                ButValue=ShowResult.text.toString()+"9"
            }
            butplusMinus.id ->{
                if(ShowResult.text.toString().contains("-"))
                ButValue=ShowResult.text.toString().substring(1)
                else
                    ButValue= "-"+ShowResult.text.toString()
            }
            butBack.id ->{
                try {
                ButValue=ShowResult.text.toString().substring(0,ShowResult.text.toString().length-1)}
                catch (E:Exception){
                    Toast.makeText(this,"ENPUT NUMBER FIRST",Toast.LENGTH_LONG).show()
                }
            }
            else->
            {

                Toast.makeText(this,"Enter number", Toast.LENGTH_LONG).show()
            }
        }
        ShowResult.text=ButValue
    }
var oper=""
    var oldNumber=""
    var newNumber=""
    var History=""
    var newopera=true
    fun EventOP(view: View) {

        val buselec = view as Button

        if (ShowResult.text.toString() != "") {
            when (buselec.id) {
                butDiv.id -> {
                    oper = "/"
                }
                butMUlt.id -> {
                    oper = "*"
                }
                butMinus.id -> {
                    oper = "-"
                }
                butPlus.id -> {
                    oper = "+"
                }

                butMod.id -> {
                    oper = "%"
                }
                butSqr.id -> {
                    oper = "Sqr"
                }
                else -> {
                    Toast.makeText(this, "enter correct operation", Toast.LENGTH_LONG).show()
                }
            }

            if (ShowResult.text.toString() != "" && oldNumber != ShowResult.text.toString()) {
                oldNumber = ShowResult.text.toString()
                History = ""

                if (oper == "Sqr") {

                    History = History+"= $oldNumber "+"\n"+ "SQUARE($oldNumber)"
                } else History = History + oldNumber + " $oper "
            } else {
                if (oper == "Sqr") {
                    History = History+"=$oldNumber "+"\n"+ "SQUARE($oldNumber)"
                } else History = History + " $oper "
            }
            HistoryResult.text = History
            ShowResult.text=""
            butEqual.isEnabled=true
        }
    }
    fun EVENTRESULT(view: View) {
        //todo history button work
var buselec=view as Button
        when(buselec.id){
            butEqual.id->{
                if(ShowResult.text.toString()!="")
                    newNumber=ShowResult.text.toString()

                History=History+newNumber
                HistoryResult.text=History
                var result:Double=0.0
                try{
                when(oper){
                    "/"->{
                        result= (oldNumber.toDouble()/newNumber.toDouble())
                        ShowResult.setText(result.toString())
                        oldNumber=result.toString()
                        newNumber=""
                    }
                    "*"->{
                        result= (oldNumber.toDouble()*newNumber.toDouble())
                        ShowResult.setText(result.toString())
                        oldNumber=result.toString()
                        newNumber=""
                    }
                    "-"->{
                        result= (oldNumber.toDouble()-newNumber.toDouble()).toDouble()
                        ShowResult.setText(result.toString())
                        oldNumber=result.toString()
                        newNumber=""
                    }
                    "+"->{
                        result= (oldNumber.toDouble()+newNumber.toDouble()).toDouble()
                        ShowResult.setText(result.toString())
                        oldNumber=result.toString()
                        newNumber=""
                    }

                    "%"->{
                        result= (oldNumber.toDouble()%newNumber.toDouble()).toDouble()
                        ShowResult.setText(result.toString())
                        oldNumber=result.toString()
                        newNumber=""
                    }
                    "Sqr"->
                    {
                        result= (oldNumber.toDouble()*oldNumber.toDouble()).toDouble()
                        ShowResult.setText(result.toString())
                        oldNumber=result.toString()
                    }
                    else->
                    {
                        buselec.isEnabled=false
                    }
                }
                oper=""}
                catch (e:Exception){
                    HistoryResult.setText(e.message.toString())

                }

            }
            butHis.id->{
                var txt=ShowResult.text.toString()
                ShowResult.text=History
                HistoryResult.text=txt
            }
            butClear.id->{

                    History=""
                    oldNumber=""
                    newNumber=""
                    oper=""
                    HistoryResult.text=""
                    ShowResult.text=""

            }
        }
    }
}




