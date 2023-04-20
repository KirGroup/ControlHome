package com.example.myhouse.view.cameras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse.databinding.ItemCameraBinding
import com.example.myhouse.model.rest.rest_entites.CameraDTO
import com.squareup.picasso.Picasso

class CamerasAdapter : RecyclerView.Adapter<CamerasAdapter.CamerasViewHolder>() {

    private var cameras: List<CameraDTO> = listOf()

    fun setData(data: List<CameraDTO>) {
        cameras = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamerasViewHolder {
        val binding: ItemCameraBinding =
            ItemCameraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CamerasViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CamerasViewHolder, position: Int) {
        holder.bind(cameras[position])
    }

    override fun getItemCount() = cameras.size

    inner class CamerasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(camera: CameraDTO) {
            ItemCameraBinding.bind(itemView).apply {
                cameraItemName.text = camera.name
                if (camera.rec) cameraItemRec.visibility = View.VISIBLE
                if (camera.favorites) cameraItemFavorite.isChecked = true
                if (camera.snapshot.isBlank()) {
                    val urlSnapshot =
                        "https://png.pngtree.com/png-vector/20190820/ourmid/pngtree-no-image-vector-illustration-isolated-png-image_1694547.jpg"
                    Picasso.get().load(urlSnapshot).into(cameraItemImageView)
                } else {
                    val urlSnapshot: String = camera.snapshot
                    Picasso.get().load(urlSnapshot).into(cameraItemImageView)
                }
            }
        }
    }
}