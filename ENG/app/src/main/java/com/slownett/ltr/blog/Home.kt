package com.slownett.ltr.blog

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.ticket.view.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import android.app.SearchManager
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.*
import com.squareup.picasso.Picasso
import org.json.JSONArray
import android.net.ConnectivityManager
import android.os.*
import android.support.annotation.RequiresApi
import android.support.design.widget.NavigationView
import android.support.v4.view.MenuItemCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.widget.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.navigation_header.*
import maes.tech.intentanim.CustomIntent
import java.lang.reflect.Field
import maes.tech.intentanim.CustomIntent.customType


class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //TODO: onclick Navigation Bar Items
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId) {


            R.id.imageView5->{

            }
            R.id.home->{
                list.dividerHeight=2
                try {
                    textView5.visibility=View.INVISIBLE

                    adapter = ArticlesAdapter(
                            baseContext, listOfArticles)
                    list.adapter = adapter
                }catch (ex:Exception){
                    Toast.makeText(this,"No Internet connection",Toast.LENGTH_LONG).show()
                }

            }
            R.id.info -> {
                try {
                    textView5.visibility=View.INVISIBLE

                    var intent = Intent(this, Info::class.java)
                    startActivity(intent)
                } catch (ex: Exception) {
                    Toast.makeText(this, "No Internet connection", Toast.LENGTH_LONG).show()
                }

            }
            R.id.news -> {
                try {


                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("news")) {

                            result.add(article)


                        }
                    }
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE
                    if (result.size==0){
                        list.dividerHeight=0
                        if(isNetworkStatusAvialable (getApplicationContext())) {

                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter
                }catch (ex:Exception){
                }


            }
            R.id.exclu -> {
                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("exclu")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }
                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter
                }catch (ex:Exception){
                }

            }
            R.id.you -> {

                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("episodes")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter
                }catch (ex:Exception){
                }

            }
            R.id.android -> {
                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("android")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter

                }catch (ex:Exception){
                }

            }
            R.id.win -> {
                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("windows")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter
                }
                catch (ex:Exception){
                }

            }
            R.id.coding -> {
                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("coding")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter
                }catch (ex:Exception){
                }

            }
            R.id.fb -> {
                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("facebook")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter
                }catch (ex:Exception){
                }

            }
            R.id.web -> {
                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("websites")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter
                }catch (ex:Exception){
                }

            }
            R.id.pro -> {
                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("programs")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter
                }catch (ex:Exception){
                }

            }
            R.id.game -> {
                try {
                    list.dividerHeight=2

                    textView5.visibility=View.INVISIBLE

                    var result = ArrayList<Articles>()
                    for (i in 0..20) {
                        var article = listOfArticles[i]

                        if (article.label!!.contains("games")) {

                            result.add(article)


                        }
                    }
                    if (result.size==0){
                        list.dividerHeight=0

                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE
                        } else {


                        }

                    }

                    adapter = ArticlesAdapter(
                            baseContext, result)
                    list.adapter = adapter

                }catch (ex:Exception){
                }

            }


        }
        mdrawer.closeDrawer(Gravity.START, true)
        return true

    }

    private var mFirebaseAnalytics:FirebaseAnalytics?=null
    var adapter:ArticlesAdapter?=null
    var listOfArticles=ArrayList<Articles>()

    //TODO: Drawer layout implementaion
    private lateinit var mdrawer:DrawerLayout
    private lateinit var mToggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        //TODO: Configure intent animation
        CustomIntent.customType(this, "bottom-to-up")

        //TODO: Disable Title
        this.supportActionBar!!.setDisplayShowTitleEnabled(false)

        //TODO: Configure Firebase analytics
        mFirebaseAnalytics= FirebaseAnalytics.getInstance(this)


        //TODO: Show Icon in action bar
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.logofinal)
        supportActionBar!!.setDisplayUseLogoEnabled(true)



        //TODO: Change direction from right to left
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            window.decorView.layoutDirection=View.LAYOUT_DIRECTION_RTL
        }*/


        //TODO: change visibility of navigation drawer items
        var menu:Menu=NavigationView.menu
        menu.findItem(R.id.app_bar_search).isVisible = false


        //TODO: Progress bar visibility
        progressBar.visibility=View.VISIBLE


        //TODO: Activate drawer
        mdrawer= findViewById(R.id.drawerlayout)
        mToggle= ActionBarDrawerToggle(this,mdrawer,R.string.open,R.string.close)
        mdrawer.addDrawerListener(mToggle)
        mToggle.syncState()
        mdrawer.setPadding(0,0,0,0)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        NavigationView.setNavigationItemSelectedListener(this)





        //TODO: configure swipe tp refresh
        swipeRefreshLayout.setOnRefreshListener {

            when(swipeRefreshLayout.isRefreshing){
                true->{
                    overridePendingTransition(0, 0)
                    startActivity(Intent(this, Home::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    overridePendingTransition(0, 0)
                }
            }

        }

        //TODO: Check if network is available to do the task
        if(isNetworkStatusAvialable (getApplicationContext())) {
            val url="https://annewstn.blogspot.com/feeds/posts/default?alt=json"
            MyAsyncTask().execute(url)
        } else {
            imageView11.visibility=View.VISIBLE
            textView4.visibility=View.VISIBLE
            progressBar.visibility=View.INVISIBLE


        }


        //TODO: ADMOB ADS
        MobileAds.initialize(this, "ca-app-pub-9723852870925367~4072703730")
        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-9723852870925367/6117247294"
        lateinit var mAdView : AdView
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)





        //TODO: Add footer to listview
        var empty=TextView(this)
        empty.height=70
        list.addFooterView(empty)


        //TODO: Disable divider
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            list.setFooterDividersEnabled(false)
        }
    }

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


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        //TODO: configure search menu
        var sv:SearchView = menu.findItem(R.id.app_bar_search).actionView as SearchView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            sv.textDirection=View.TEXT_DIRECTION_RTL
        }
        val sm= getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                try {
                        textView5.visibility=View.INVISIBLE
                    var result = ArrayList<Articles>()
                        for (i in 0..20){
                            var article = listOfArticles[i]

                            if (article.title!!.toUpperCase().contains(query.toUpperCase())) {

                                result.add(article)



                            }
                        }

                    if (result.size==0){
                        if(isNetworkStatusAvialable (getApplicationContext())) {
                            textView5.visibility=View.VISIBLE

                        }else{
                            textView5.visibility=View.INVISIBLE


                        }
                    }

                        adapter= ArticlesAdapter(
                                baseContext, result)
                        list.adapter =adapter


                }catch (ex:Exception){}

                return false
            }


            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        sv.setOnSearchClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                // hide "x" button if there is no text
            }
        })
        sv.queryHint=" Search here"
        sv.setPadding(40,0,0,0)


        //TODO: visibility of items in menu
        menu.findItem(R.id.home).isVisible=false
        menu.findItem(R.id.news).isVisible=false
        menu.findItem(R.id.exclu).isVisible=false
        menu.findItem(R.id.you).isVisible=false
        menu.findItem(R.id.android).isVisible=false
        menu.findItem(R.id.win).isVisible=false
        menu.findItem(R.id.coding).isVisible=false
        menu.findItem(R.id.fb).isVisible=false
        menu.findItem(R.id.web).isVisible=false
        menu.findItem(R.id.pro).isVisible=false
        menu.findItem(R.id.game).isVisible=false
        menu.findItem(R.id.info).isVisible=false


        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //TODO : configure button of drawer
        if (mToggle.onOptionsItemSelected(item)){
            return true
        }
        //TODO: Info button onclick
        when(item!!.itemId){
            R.id.info->{
                try {
                    var intent= Intent(this,Info::class.java)
                    startActivity(intent)
                }catch (ex:Exception){
                    Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show()
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }


    //TODO: ARTICLE ADAPTER TO SHOW ARTCILES
    class  ArticlesAdapter:BaseAdapter {

        var listOfArticles= ArrayList<Articles>()
        var context:Context?=null
        constructor(context:Context,listOfArticles:ArrayList<Articles>):super(){
            this.context=context
            this.listOfArticles=listOfArticles
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var article = this.listOfArticles[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var articleView= inflator.inflate(R.layout.ticket,null)

            articleView.textView2.text =  article.date!!

            articleView.etlabel.text=article.label!!

            var title=""
            if (article.title!!.length>83){
                for (i in 0..79){
                    title+= article.title!![i].toString()
                }
                title += "..."
            }else{
                title= article.title!!
            }

            articleView.textView.text = title

            (Picasso.get().load(article.img).centerCrop().placeholder(R.drawable.progress_animation)
                    .error(R.drawable.error)
                    .fit()
                    .into(articleView.imageView4))





            articleView.layout.setOnClickListener {



                val intent = Intent(context,Details::class.java)
                intent.putExtra("name",article.title!!)
                intent.putExtra("des",article.des!!)
                intent.putExtra("img",article.img.toString())
                intent.putExtra("date",article.date)
                intent.putExtra("share",article.share)




                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context!!.startActivity(intent)
                CustomIntent.customType(it.context, "left-to-right")


            }


            return  articleView

        }

        override fun getItem(p0: Int): Any {
            return listOfArticles[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return listOfArticles.size
        }

    }



    //TODO: Load articles from Json Feed
    inner class MyAsyncTask: AsyncTask<String, String, String>() {

        override fun onPreExecute() {
            //Before task started
        }
        override fun doInBackground(vararg p0: String?): String {
            try {
                val url=URL(p0[0])
                val urlConnect=url.openConnection() as HttpsURLConnection
                urlConnect.connectTimeout=7000

                var inString= ConvertStreamToString(urlConnect.inputStream)
                //Cannot access to ui
                publishProgress(inString)
            }catch (ex:Exception){}

            return " "

        }

        override fun onProgressUpdate(vararg values: String?) = try{

            //TODO: COLLECT DATA FROM JSON FEED
            var json=JSONObject(values[0])
            val feed=json.getJSONObject("feed")
            val results:JSONArray=feed.getJSONArray("entry")





            for (i in 0 until 25) {


                var myarticle=results.getJSONObject(i)
                var firstt:JSONObject =myarticle.getJSONObject("title")
                var title=firstt.getString("\$t")

                var second =myarticle.getJSONObject("content")
                var des=second.getString("\$t")



                var media=myarticle.getJSONObject("media\$thumbnail")
                var img=media.getString("url")
                      .replace("s72-c","s1600")

                var uri=Uri.parse(img)

                var third=myarticle.getJSONObject("published")
                var fdate:String =third.getString("\$t")

                var labels=myarticle.getJSONArray("category")

                var labelf=""

                for (j in 0 until labels.length()){
                    var firsttt=labels.getJSONObject(j)
                    var label=firsttt.getString("term")

                    labelf= "$labelf  $label"
                }






                var date=""
                for (j in 0..9){
                    date += fdate[j].toString()

                }

                var link=myarticle.getJSONArray("link")
                var linkarray=link.getJSONObject(4)




                var share=linkarray.getString("href")






                listOfArticles.add(Articles(title,des,uri,date,share,labelf))









            }





        }catch (ex:Exception){
            progressBar.visibility=View.INVISIBLE

            Toast.makeText(baseContext,ex.toString(),Toast.LENGTH_LONG).show()
        }



        override fun onPostExecute(result: String?) {

            //after task done
            adapter= ArticlesAdapter(baseContext,listOfArticles)
            list.adapter =adapter
            progressBar.visibility=View.INVISIBLE

        }


    }
    fun ConvertStreamToString(inputStream:InputStream):String{

        val bufferReader=BufferedReader(InputStreamReader(inputStream))
        var line:String
        var AllString:String=""

        try {
            do{
                line=bufferReader.readLine()
                if(line!=null){
                    AllString+=line
                }
            }while (line!=null)
            inputStream.close()
        }catch (ex:Exception){}



        return AllString
    }






}















