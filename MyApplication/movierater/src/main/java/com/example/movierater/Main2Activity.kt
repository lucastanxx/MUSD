package com.example.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        class MovieDetails( movieName:String, descriptions:String,date:String,language:String,agesuitable:String){
            var movieName: String
            var descriptions: String
            var date: String
            var language : String
            var agesuitable : String
            init {
                this.movieName =movieName
                this.descriptions =descriptions
                this.date =date
                this.language=language
                this.agesuitable=agesuitable
            }
        }
        var venom =MovieDetails("Venom","When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life","03-10-2018","English","Yes")
        titleText.text = venom.movieName
        overViewText.text =  venom.descriptions
        languageText.text = venom.language
        releaseText1.text = venom.date
        suitableText.text = venom.agesuitable

    }
}
