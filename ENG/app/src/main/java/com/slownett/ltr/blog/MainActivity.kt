package com.slownett.ltr.blog

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import maes.tech.intentanim.CustomIntent


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        var back=object :Thread(){
            override fun run() {
                try {
                    Thread.sleep(3/2*1000.toLong())
                    var intent=Intent(baseContext,Home::class.java)
                    startActivity(intent)


                }catch (ex:Exception){
                    Toast.makeText(baseContext,"Unknown Error",Toast.LENGTH_LONG).show()
                }
            }
        }
        back.start()
    }
}
