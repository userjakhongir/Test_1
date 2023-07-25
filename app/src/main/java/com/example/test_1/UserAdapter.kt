package com.example.test_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.test_1.databinding.Item1Binding
import com.example.test_1.model.UsermModel


class UserAdapter constructor(
    val context: android.content.Context,
    var arrayList: ArrayList<UsermModel>
):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val view = Item1Binding.inflate(LayoutInflater.from(context),parent,false)
        return UserViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.binding.apply {
           textviewitemSavol.text = arrayList.get(position).question
           textviewitemJavob1.text = arrayList.get(position).answer1
           textviewitemJavob2.text = arrayList.get(position).answer2
           textviewitemJavob3.text = arrayList.get(position).answer3
            textviewitemJabov4.text = arrayList.get(position).answer4
       }
    }
    override fun getItemCount(): Int = arrayList.size

    class UserViewHolder(val binding: Item1Binding):RecyclerView.ViewHolder(binding.root)
}