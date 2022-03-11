package com.apps.widdleapp

object Validator {
    fun Validateintputs(name:String,mobile:String,desc:String): Boolean {
        return !(name.isEmpty() || mobile.isEmpty()  || desc.isEmpty())
    }
}