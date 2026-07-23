package com.definelab.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.definelab.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    lateinit var userName: EditText
//    lateinit var userMessage: EditText
//    lateinit var counter: Button
//    lateinit var remember: CheckBox

    lateinit var mainBinding: ActivityMainBinding
    var count : Int = 0
    var username : String? = null
    var message : String? = null
    var isChecked :Boolean? = null

    lateinit var sharedPreferences: SharedPreferences





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.button.setOnClickListener {
            count++
            mainBinding.button.setText(" " +count )
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStop() {
        super.onStop()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    fun saveData(){
        sharedPreferences =this.getSharedPreferences("saveData", Context.MODE_PRIVATE)

        username = mainBinding.editTextName.text.toString()
        message = mainBinding.editTextmessage.text.toString()
//        count = mainBinding.button.toString().toInt()
        isChecked = mainBinding.checkBox.isChecked

        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("message", message)
        editor.putInt("count", count)
        editor.putBoolean("isChecked", isChecked!!)
        editor.apply()

        Toast.makeText(applicationContext, "Data Saved", Toast.LENGTH_SHORT).show()
    }

    fun loadData() {
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        username = sharedPreferences.getString("username", null)
        message = sharedPreferences.getString("message", null)
        count = sharedPreferences.getInt("count", 0)
        isChecked = sharedPreferences.getBoolean("isChecked", false)

        mainBinding.editTextName.setText(username)
        mainBinding.editTextmessage.setText(message)
        mainBinding.button.setText(""+count)
        mainBinding.checkBox.isChecked = isChecked!!

        Toast.makeText(applicationContext, "Data Loaded", Toast.LENGTH_SHORT).show()
    }


}