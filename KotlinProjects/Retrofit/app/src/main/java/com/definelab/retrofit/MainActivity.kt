package com.definelab.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.definelab.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val baseUrl : String = "https://jsonplaceholder.typicode.com"

    lateinit var mainBinding: ActivityMainBinding

    var postsList = ArrayList<Posts>()

    lateinit var adapter: PostsAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = PostsAdapter(postsList)
//        mainBinding.recyclerView.adapter = adapter

        showPosts()



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun showPosts(){
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val retrofitAPI : RetrofitAPI = retrofit.create(RetrofitAPI::class.java)
        val call : Call<List<Posts>> = retrofitAPI.getAllPosts()
        call.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(
                p0: Call<List<Posts>>,
                response: Response<List<Posts>>
            ) {
                if(response.isSuccessful){
                    postsList = response.body() as ArrayList<Posts>
                    adapter = PostsAdapter(postsList)
                    mainBinding.recyclerView.adapter = adapter
                    mainBinding.progressBar2.isVisible = false
                    mainBinding.recyclerView.isVisible = true
                }
//                if(!response.isSuccessful){
//                    mainBinding.Userid.text = "error"
//                    mainBinding.Id.text = "error"
//                    mainBinding.Title.text = "error"
//                    mainBinding.Body.text = "error"
//                }
//
//                postsList = response.body() as ArrayList<Posts>
//
//                mainBinding.Userid.text = postsList[0].userId.toString()
//                mainBinding.Id.text = postsList[0].id.toString()
//                mainBinding.Title.text = postsList[0].title
//                mainBinding.Body.text = postsList[0].subtitle
            }

            override fun onFailure(
                p0: Call<List<Posts>>,
                p1: Throwable
            ) {
                //Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_SHORT).show()
                //or
                Toast.makeText(applicationContext,p1.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
}