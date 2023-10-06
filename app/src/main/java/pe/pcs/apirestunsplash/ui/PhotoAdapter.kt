package pe.pcs.apirestunsplash.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import pe.pcs.apirestunsplash.databinding.ItemsResultBinding
import pe.pcs.apirestunsplash.domain.model.Photo

class PhotoAdapter() : ListAdapter<Photo, PhotoAdapter.BindViewHolder>(DiffCallback) {

    private object DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }

    inner class BindViewHolder(private val binding: ItemsResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun enlazar(entidad: Photo) {
            binding.imageView.load(entidad.urls?.regular) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            binding.tvDescripcion.text = entidad.description
            binding.tvLike.text = "Likes: ${entidad.likes.toString()}"
            binding.tvDate.text = entidad.createdAt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        return BindViewHolder(
            ItemsResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindViewHolder, position: Int) {
        holder.enlazar(
            getItem(position)
        )
    }

}