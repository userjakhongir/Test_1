package com.example.test_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test_1.databinding.ActivityMainBinding
import com.example.test_1.model.UsermModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var databaseReference: DatabaseReference
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User")

        binding.apply {
         btnAdd.setOnClickListener {
             val usermModel = UsermModel(
                 //edittextTalimShakli.text.toString(),
                // edittextKursi.text.toString(),
                // edittextFannomi.text.toString(),
                 edittextSavol.text.toString(),
                 edittextVariyant1.text.toString(),
                 edittextVariyant2.text.toString(),
                 edittextVariyant3.text.toString(),
                 edittextVariyant4.text.toString(),
                 edittextTogrijavob.text.toString()
             )
             databaseReference.child("${edittextTalimShakli.text.toString()}").
             child("${edittextKursi.text.toString()}").child("${edittextFannomi.text.toString()}").
                 child("${count}").setValue(usermModel)
             count++
         }
        }


    }
}