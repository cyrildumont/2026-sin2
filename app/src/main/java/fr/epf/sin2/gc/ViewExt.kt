package fr.epf.sin2.gc

import android.util.Log
import android.view.View

private const val TAG = "ViewExt"

fun View.click(action : (View) -> Unit){
    Log.d(TAG, "Click sur ${this.id}")
    this.setOnClickListener(action)
}