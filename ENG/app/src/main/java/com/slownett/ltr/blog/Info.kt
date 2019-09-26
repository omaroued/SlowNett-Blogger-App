package com.slownett.ltr.blog

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_info.*
import maes.tech.intentanim.CustomIntent

class Info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        //TODO: Change direction from right to left
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            window.decorView.layoutDirection= View.LAYOUT_DIRECTION_RTL
        }*/


        //TODO: remove title from bar
        this.supportActionBar!!.setDisplayShowTitleEnabled(false)



        //TODO: show return button
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        //TODO: Configure social media button
        facebook.setOnClickListener {
            var intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/slownett/"))
            startActivity(intent)
        }
        twitter.setOnClickListener {
            var intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/invite/4iOeSb8aSi4FB0NEGrKQKe"))
            startActivity(intent)
        }
        instagram.setOnClickListener{
            var intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/slownettoficial/"))
            startActivity(intent)
        }
        youtube.setOnClickListener {
            var intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC6mAUlfn1dOy_KRuNSXvy0A"))
            startActivity(intent)
        }

        //TODO: Configure mail button
        linMail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("contact@slownett.com"))
            startActivity(intent)
        }



    }

    //TODO: Configure finish button
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            android.R.id.home->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    //TODO: Configure finish animation
    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "right-to-left")

    }
}
