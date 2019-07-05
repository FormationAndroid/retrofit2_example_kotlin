package com.monentreprise.stackquestions.adapters

import androidx.recyclerview.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.monentreprise.stackquestions.R
import com.monentreprise.stackquestions.api.models.Repo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_question.view.*

class ReposAdapter (private val repos: List<Repo>) : RecyclerView.Adapter<ReposAdapter.ViewHolder>() {

    private lateinit var mOnItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(repos.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtQuestion: TextView = itemView.textQuestion
        var txtName: TextView = itemView.textName
        var txtReputation: TextView = itemView.textReputation
        var imgProfil: ImageView = itemView.imgProfil

        fun bindItems(repo: Repo?) {
            txtQuestion.text = repo?.fullName ?: ""

            itemView.setOnClickListener { mOnItemClickListener.onItemClick(repo) }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(repo: Repo?)
    }

    override fun getItemCount() = repos.size

}
