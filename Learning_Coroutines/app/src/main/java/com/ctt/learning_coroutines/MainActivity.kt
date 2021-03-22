package com.ctt.learning_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var text : TextView
    private val RESULT_1 = "Result #1"
    private val RESULT_2 = "Result #2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        text = findViewById(R.id.text)

        button.setOnClickListener {

//          launching a coroutine inside here
//            scoping -> a way to organize coroutines into groupings = grouping a bunch of coroutines together
//            a way to group them together so if one fail we can cancel them or do something to the whole group
//            similar categories so we can take action on many of them at once

//            the 3 coroutines scopes most used: IO, Main, Default

//            IO -> means input output -> network requests or requests to a local db
//            CoroutineScope(IO)

//            Main -> to do work on the main thread -> working with ui
//            CoroutineScope(IO)

//            for doing any heavy computation work -> filter a large list and pick things out and arrange at different ways
//            CoroutineScope(Default)

            CoroutineScope(IO).launch {
//                coroutine builder -> launch -> constructs the coroutine and gets it ready to go

                fakeApiRequest()

            }
        }
    }

//    as it is it will still crash because its not being called from the main thread -> it will be run on whatever thread it is called upon
//    to solve this -> create another suspend fun
    private fun setNewText(input: String) {
//        getting whatever text is already on the textview and appending a new text
        val newText = text.text.toString() + "\n$input"
        text.text = newText
    }

    private suspend fun setTextOnMainThread(input: String) {
//        start a new coroutine that will do its work on the main thread instead of doing it on IO or DEFAULT
//        you can do it 2 ways:
//        CoroutineScope(main)
//        or
        withContext(Main) {
//            switch the context of the coroutine to whatever you mention -> thread independent
//            you can start a coroutine in one thread and pass to another to do some work, and then pass to another

//            launch will start a coroutine and withcontext will switch the context of that coroutine -> change where it is doing its work
//             so you dont need to create new coroutines


//            this will set up a new coroutine and get it started
            setNewText(input)
        }
    }

    private suspend fun fakeApiRequest() {
//        this cannot be called inside this function because it has to be called from another suspended function or a coroutine
//        async call inside a normal function
//        val result1 = getResult1FromApi()

        var result1 = getResult1FromApi()
        println("debug: $result1")

//        after it brings the result -> if we want to update the value to a textview we cannot do it here as it will crash the app
//        we have been working on a secondary thread whilst the ui updating should take place at the main thread
//        so we need to send these results to the main thread where it can then be set to the textview

//        after creating a new coroutine in the main scope
        setTextOnMainThread(result1)

//        so after setting the text on main thread to result1 we will get the result2 from api

        val result2 = getResult2FromApi()
        setTextOnMainThread(result2)

//        when you call suspended functions within the same job they wait for completion -> it executes synchronously
//        first it will wait to get the result1 from api
//        then it sets the text
//        then it retrieves result 2
//        and finally it sets text to result 2
    }

//    suspend -> can be asynchronous -> able to be used in coroutines -> and then executed in the background thread
    private suspend fun getResult1FromApi() : String {
        logThread("getResult1FromApi")
//    only delay the single coroutine and will not interfere with the other coroutines
        delay(1000)

//    this will delay the entire thread (with its many coroutines inside)
//        Thread.sleep(1000)

    return RESULT_1
    }

    private suspend fun getResult2FromApi() : String {
        logThread("getResult2Api")
        delay(1000)
        return RESULT_2
    }

    private fun logThread(methodName: String) {
        println("Debug: ${methodName}: ${Thread.currentThread().name}")
    }
}

// many coroutines can be running at the same time inside a thread -> coroutines are like the jobs to be done while thread is where they are done
// you can have any number of coroutines inside a thread