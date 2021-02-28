package com.ctt.pet4jokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ctt.pet4jokes.databinding.ActivityJokeBinding

class JokeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJokeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val Jokes: List<String> = listOf<String>(
            "\"Bugs come in through open Windows.\"",
            "\"Roses are #ff0000, violets are #0000ff, I use hex codes, but I'd use RGB for you\"",
            "\"Chuck Norris can access the DB from the UI.\"",
            "\"The Internet: where men are men women are men and children are FBI agents.\"",
            "\"Chuck Norris's keyboard has the Any key.\"",
            "\"Chuck Norris can retrieve anything from /dev/null.\"",
            "\"CAPS LOCK – Preventing Login Since 1980.\"",
            "\"joke\": \"I've got a really good UDP joke to tell you, but i don't know if you'll get it\"",
            "\"If Chuck Norris writes code with bugs, the bugs fix themselves.\"",
            "\"Chuck Norris's keyboard doesn't have a Ctrl key because nothing controls Chuck Norris.\"",
            "\"There are only 10 types of people in the world: those that understand binary and those that don’t.\"",
            "\"Computers make very fast and very accurate mistakes.\"",
            "\"To err is human – and to blame it on a computer is even more so.\"",
            "\"Computers are like air conditioners: they stop working when you open Windows.\"",
            "\"If at first you don’t succeed; call it version 1.0.\"",
            "\"My software never has bugs. It just develops random features.\"",
            "\"I would love to change the world but they won’t give me the source code.\"",
            "\"Programming today is a race between software engineers striving to build bigger and better idiot-proof programs and the Universe trying to produce bigger and better idiots. So far the Universe is winning.\"",
            "\"Hey! It compiles! Ship it!\"",
            "\"Evolution is God’s way of issuing upgrades.\""
        )

        val rand = (Math.random() * (Jokes.size + 1)).toInt()
        var randomJoke : String = Jokes[rand]

        binding.txtJoke.text = randomJoke
    }
}


// TODO: 28/02/2021 integrate jokes with api 
//<!--jokes from https://geek-jokes.sameerkumar.website/api?format=json-->