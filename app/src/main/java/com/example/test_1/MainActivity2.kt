package com.example.test_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_1.databinding.ActivityMain2Binding
import com.example.test_1.model.UsermModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var databaseReference: DatabaseReference
    var arrayList = ArrayList<UsermModel>()
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child("kunduzgi").child("2-kurs").child("falsafa")

        databaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (datasnapshot:DataSnapshot in snapshot.children){
                    val usermModel = datasnapshot.getValue(UsermModel::class.java)
                    arrayList.add(usermModel!!)
                }
                userAdapter = UserAdapter(this@MainActivity2,arrayList)
                binding.apply {
                    reecyclerview1.layoutManager = LinearLayoutManager(this@MainActivity2)
                    reecyclerview1.adapter = userAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })



    }
}