package com.eastcom.architecture.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.eastcom.architecture.R
import com.eastcom.architecture.entity.Word
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class WordListAdapter internal constructor(context: Context): androidx.recyclerview.widget.RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>() // Cached copy of words

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WordViewHolder {
        return WordViewHolder(inflater.inflate(R.layout.recyclerview_item,p0,false))
    }
    override fun getItemCount() = words.size

    override fun onBindViewHolder(WordViewHolder: WordViewHolder, p1: Int) {
        WordViewHolder.wordItemView.text = words[p1].word
    }

    internal fun setWords(words:List<Word>){
        this.words = words
        notifyDataSetChanged()
    }

    inner class WordViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val wordItemView:TextView = itemView.findViewById(R.id.textView)
    }
}