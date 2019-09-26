package com.slownett.ltr.blog

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

//TODO: Apply notification
class MyFirebaseInstanceIDService:FirebaseInstanceIdService(){
    override fun onTokenRefresh() {
        super.onTokenRefresh()

        var token=FirebaseInstanceId.getInstance().token

        Log.d("Token",token)
    }
}