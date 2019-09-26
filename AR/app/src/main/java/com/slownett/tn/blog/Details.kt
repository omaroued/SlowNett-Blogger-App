package com.slownett.tn.blog

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_details.*
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.squareup.picasso.Picasso
import maes.tech.intentanim.CustomIntent


@Suppress("IMPLICIT_CAST_TO_ANY")
class Details : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



        if(isNetworkStatusAvialable (applicationContext)) {

        } else {
            textView2.visibility=View.INVISIBLE
            textView3.visibility=View.INVISIBLE
            webview.visibility=View.INVISIBLE
            imDetails.visibility=View.INVISIBLE
            imageView11.visibility=View.VISIBLE
            textView4.visibility=View.VISIBLE

        }

        //TODO: Support RTL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            window.decorView.layoutDirection=View.LAYOUT_DIRECTION_RTL
        }

        //TODO :Action bar
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar!!.setDisplayShowTitleEnabled(false)





        //TODO :Swipe to refresh
        swipe.setOnRefreshListener {
            when(swipe.isRefreshing){
                true->{



                     swipe.isRefreshing
                     val intent=intent
                     intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                     overridePendingTransition(0, 0)
                     finish()
                     overridePendingTransition(0, 0)

                     overridePendingTransition(0, 0)
                     startActivity(intent)
                     overridePendingTransition(0, 0)

                }
            }

        }



        val bundle=intent.extras
        textView2.text=bundle.getString("name")
        var img=bundle.getString("img")

        var date="نشر بتاريخ: "+bundle.getString("date")
        textView3.text=date

        //TODO : Description replace
        var rimg=img
                .replace("s1600","s640")

        var desprim=bundle.getString("des")
        var n:Int=desprim.indexOf("<img")
        var f=desprim.indexOf("/>")
        var word=""
        for (i in n..f+1){
            word+=desprim[i]
        }

        var des=bundle.getString("des")
                .replace(word,"")
                .replace("width=\"640\"","")
                .replace("data-original-height=\"900\" data-original-width=\"1600\" height=\"360\"","style=\"width:100%!important\"")
                .replace("margin-right: 1em;","")
                .replace("data-original-height=\"330\" data-original-width=\"660\" height=\"320\"","style=\"width:100%!important\"")
                .replace("<img border=\"0\"","<img border=\"0\" style=\"width:100%!important\"")






        //TODO: Show Image From URL
        Picasso.get().load(Uri.parse(img)).fit().centerCrop().into(imDetails)


        var myWebView=findViewById<WebView>(R.id.webview)

        //TODO :Redirect to browser
        myWebView.webViewClient = object:WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                     var url=request!!.url.toString()

                     if (url.contains(".png")||url.contains(".jpg")||url.contains(".jpg")){

                     }else{
                         var intent= Intent(Intent.ACTION_VIEW, Uri.parse(request!!.url.toString()))
                         startActivity(intent)
                     }


                } else {
                    TODO("VERSION.SDK_INT < LOLLIPOP")
                }

                return true
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

                if (url!!.contains(".png")||url!!.contains(".jpg")||url!!.contains(".jpeg")||url!!.contains(".gif")) {
                }else{
                    var intent= Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                }


                return true

            }



        }


        //TODO :Progress bar
        myWebView.webChromeClient=object :WebChromeClient(){

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                progressBar2.visibility=View.VISIBLE
                if (newProgress==100){
                    progressBar2.visibility=View.INVISIBLE
                }else{
                    progressBar2.visibility=View.VISIBLE
                }
            }

        }



        //TODO :Disable click
     //   myWebView.setOnTouchListener { _, _ -> true }




        //TODO :Disable long click
        myWebView.setOnLongClickListener(View.OnLongClickListener {
            true
        })

        //TODO :Enable JavaScript
      myWebView.settings.javaScriptEnabled=true


        //TODO :Enable webview debug
        /*
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
           WebView.setWebContentsDebuggingEnabled(true)
       } */


        // TODO :Load Des
        myWebView.loadData(des,"text/html;charset=UTF-8", "UTF-8")





        //TODO: Configure Admob Ads
        MobileAds.initialize(this, "ca-app-pub-9723852870925367~4072703730")
        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-9723852870925367/6117247294"
        lateinit var mAdView : AdView
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }


    //TODO: Configure finish animation
    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "left-to-right")

    }




    //TODO: check internet function
    fun isNetworkStatusAvialable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val netInfos = connectivityManager.activeNetworkInfo
            if (netInfos != null)
                if (netInfos.isConnected)
                    return true
        }
        return false
    }


    //TODO: Configure menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //TODO: Inflate menu
        menuInflater.inflate(R.menu.detailsmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){
            //TODO: Configure finish button
            android.R.id.home->{

                finish()
            }
        //TODO: Configure share button

            R.id.share->{
                val bundle=intent.extras
                var title=bundle.getString("name")
                var share=bundle.getString("share")
                val sendIntent = Intent()

                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, "$title \n $share ")
                sendIntent.type = "text/plain"
                startActivity(Intent.createChooser(sendIntent, "Share via"))
            }
        }

            return true
    }
}
