package com.fethicectin.orderly.Utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fethicectin.orderly.Model.PostModel
import com.fethicectin.orderly.R
import kotlinx.android.synthetic.main.question_item_layout.view.*

class QuestionRecyclerAdapter(private var postList:List<PostModel>?): RecyclerView.Adapter<QuestionRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val questionTitle = itemView.findViewById<TextView>(R.id.cardTitle)
        val questionContent = itemView.findViewById<TextView>(R.id.cardContent)
        val answerQuestionButton = itemView.findViewById<TextView>(R.id.answerButton)

        init {
            answerQuestionButton.setOnClickListener { view: View? ->
                val position: Int = adapterPosition
               Toast.makeText(itemView.context,"You clicked item ${position + 1}",Toast.LENGTH_SHORT).show()
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.question_item_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if(postList != null){
            return postList!!.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.questionTitle.text = postList?.get(position)!!.postTitle
            holder.questionContent.text = postList?.get(position)!!.postContent
    }


}

