package com.panevrn.museumsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.panevrn.museumsapp.databinding.ItemMuseumBinding

class MuseumAdapter: RecyclerView.Adapter<MuseumAdapter.MuseumHolder> {

    class MuseumHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemMuseumBinding.bind(item)
        fun bind(plant: Museum) = with(binding) {
            binding.itemMuseumName.text = itemMuseumName.text
        }
    }
}