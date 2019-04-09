package com.monentreprise.stackquestions.adapters

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.monentreprise.stackquestions.R
import com.monentreprise.stackquestions.api.models.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_question.view.*

class QuestionsAdapter (private val items: List<Item?>) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    private lateinit var mOnItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: QuestionsAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: Item?) {
            itemView.textQuestion.text = Html.fromHtml(item?.title ?: "")
            itemView.textName.text = item?.owner?.displayName
            itemView.textReputation.text = item?.owner?.reputation.toString()
            Picasso.get().load(item?.owner?.profileImage).into(itemView.imgProfil)

            itemView.setOnClickListener { mOnItemClickListener.onItemClick(item) }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(item: Item?)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
