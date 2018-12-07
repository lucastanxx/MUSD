package com.example.movierater

import android.app.Application

class MovieDetails : Application(){
    var movieName: String =""
    var descriptions: String=""
    var dates: String=""
    var language: String=""
    var agesuitable: Boolean = true
    var reviews: String = ""
    var stars : Float = 0.0f
    var reason1: Boolean= true
    var reason2: Boolean= false

    fun getMovieName1():String{
        return movieName
    }
    fun setMovieName1(test:String){
        this.movieName = test
    }
    fun getDescriptions1():String{
        return descriptions
    }
    fun setDescriptions1(test:String){
        this.descriptions = test
    }
    fun getDate1():String{
        return dates
    }
    fun setDate1(test:String){
        this.dates = test
    }
    fun getLanguage1():String{
        return language
    }
    fun setLanguage1(test:String){
        this.language = test
    }
    fun getSuitable1():Boolean{
        return agesuitable
    }
    fun setSuitable(test:Boolean){
        this.agesuitable = test
    }
    fun getReason11():Boolean{
        return reason1
    }
    fun setReason11(test:Boolean){
        this.reason1 = test
    }
    fun getReviews1():String{
        return reviews
    }
    fun setReviews1(test:String){
        this.reviews = test
    }
    fun getReason22():Boolean{
        return reason2
    }
    fun setReason22(test:Boolean){
        this.reason2 = test
    }
    fun getStarss():Float{
        return stars
    }
    fun setStarss(test:Float){
        this.stars = test
    }
}