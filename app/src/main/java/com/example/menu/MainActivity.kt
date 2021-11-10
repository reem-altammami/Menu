package com.example.menu

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.menu.databinding.ActivityMainBinding
import kotlin.math.log

var x = true
class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu , menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.setting-> {
                // Sets isLinearLayoutManager (a Boolean) to the opposite value
               val intent = Intent(this,Setting::class.java)
                this.startActivity(intent)

                return true
            }

            R.id.login ->{
                true
            }

            R.id.logout ->{
                true
            }

                R.id.contact ->{
val intent = Intent(this,ContactUs::class.java)
                    this.startActivity(intent)
                    return true}
            //  Otherwise, do nothing and use the core event handling

            // when clauses require that all possible paths be accounted for explicitly,
            //  for instance both the true and false cases if the value is a Boolean,
            //  or an else to catch all unhandled cases.
            else ->  super.onOptionsItemSelected(item)
        }

    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val login = menu?.findItem(R.id.login)
        val logout = menu?.findItem(R.id.logout)
        if (x){
            x= !x
            logout?.setVisible(true)
            login?.setVisible(false)

        }else{
            x= !x
            logout?.setVisible(false)
            login?.setVisible(true)
        }

        return super.onPrepareOptionsMenu(menu)
    }



}