package com.imnstudios.sendbro.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imnstudios.sendbro.data.models.Media
import com.imnstudios.sendbro.databinding.MediaPreviewBinding
import com.imnstudios.sendbro.util.logger
import kotlinx.android.synthetic.main.media_preview.view.*

class MediaAdapter : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    inner class ViewHolder(private val context: Context, private val binding: MediaPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(media: Media) {
            "binding".logger()
            binding.apply {
                Glide.with(context).load(media.uri).into(preview)
                blaEx.text = media.bla

            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Media>() {
        override fun areItemsTheSame(oldItem: Media, newItem: Media): Boolean {
            return oldItem.uri == newItem.uri
        }

        override fun areContentsTheSame(oldItem: Media, newItem: Media): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            parent.context,
            MediaPreviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val media = differ.currentList[position]
//        holder.bind(media)
        holder.itemView.apply {
            Glide.with(this).load(media.uri).into(preview)
            bla_ex.text = media.bla
            setOnItemClickListener {
                "setOnItemClickListener".logger()
                onItemClickListener?.let { it(media) }
            }
        }
    }

    private var onItemClickListener: ((Media) -> Unit)? = null

    fun setOnItemClickListener(listener: (Media) -> Unit) {
        onItemClickListener = listener
    }

}