package com.panevrn.museumsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.panevrn.museumsapp.databinding.ItemMuseumBinding

class MuseumAdapter(private var listMuseums: List<Museum>, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<MuseumAdapter.MuseumHolder>() {

    class MuseumHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemMuseumBinding.bind(item)
        fun bind(museum: Museum) = with(binding){
            textViewMuseumTitleItem.text = museum.name
            textViewMuseumNumberItem.text = museum.phoneNumber
            imageViewMuseumItem.setImageResource(museum.imagePath)

        }
    }
    interface OnItemClickListener {
        fun onItemClick(museum: Museum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_museum, parent, false)
        return MuseumHolder((view))
    }

    override fun onBindViewHolder(holder: MuseumHolder, position: Int) {
        val item = listMuseums[position]

        holder.bind(listMuseums[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return listMuseums.size
    }
}