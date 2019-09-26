package com.slownett.ltr.blog

import android.net.Uri

class Articles{
    var title:String?=null
    var des:String?=null

    var img:Uri?=null
    var date:String?=null
    var share:String?=null
    var label:String?=null
    constructor(title:String,des:String,img:Uri,date:String,share:String,label:String){
        this.title=title
        this.des=des
        this.img=img
        this.date=date
        this.share=share
        this.label=label

    }
}