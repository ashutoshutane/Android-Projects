package com.definelab.userregistrationapp

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.definelab.userregistrationapp.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myRef : DatabaseReference = database.reference.child("MyUsers")
    val userList = ArrayList<User>()
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this,AddUserActivity::class.java))

        }

        ItemTouchHelper(object :ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                direction: Int
            ) {
                val id = userAdapter.getUserId(viewHolder.adapterPosition)
                myRef.child(id).removeValue()
                Toast.makeText(applicationContext,"The user was deleted ", Toast.LENGTH_SHORT).show()

            }

        }).attachToRecyclerView(mainBinding.recyclerView)
        retrieveDataFromDatabase()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



    fun retrieveDataFromDatabase(){
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {


                userList.clear()

                for (eachUser in snapshot.children){
                    val user = eachUser.getValue(User::class.java)

                    if(user!=null){
                        println("userId : ${user.userId}")
                        println("userName : ${user.name}")
                        println("userAge : ${user.age}")
                        println("userEmail : ${user.email}")
                        println("**************************")

                        userList.add(user)
                    }

                    userAdapter = UserAdapter(this@MainActivity,userList)

                    mainBinding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                    mainBinding.recyclerView.adapter = userAdapter
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_delete_all,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.deleteAll){
            showDialogMessage()
        }
        return super.onOptionsItemSelected(item)
    }
    fun showDialogMessage(){
        val dialogMessage = AlertDialog.Builder(this)
        dialogMessage.setTitle("Delete All Users")
        dialogMessage.setMessage("if click Yes , all users will be Deleted," + "If you want to delete a specific user swipe to left or right")
        dialogMessage.setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialogInterface,i ->
            dialogInterface.cancel()
        })

        dialogMessage.setPositiveButton("Yes", DialogInterface.OnClickListener{ dialogInterface,i ->
            myRef.removeValue().addOnCompleteListener {task ->
                if(task.isSuccessful){
                    userAdapter.notifyDataSetChanged()
                    Toast.makeText(applicationContext,"All Users were deleted", Toast.LENGTH_SHORT).show()
                }
            }
        })
        dialogMessage.create().show()
    }
}