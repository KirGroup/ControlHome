package com.example.myhouse.view.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse.databinding.ItemDoorBinding
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.squareup.picasso.Picasso


class DoorsAdapter(private var itemClickListener: OnListItemClickListener) :
    RecyclerView.Adapter<DoorsAdapter.DoorsViewHolder>() {

    private lateinit var realmManager: RealmManager
    private var doors: List<DoorDTO> = listOf()

    fun setData(data: List<DoorDTO>) {
        doors = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        val binding: ItemDoorBinding =
            ItemDoorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoorsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(doors[position])
    }

    override fun getItemCount() = doors.size

    inner class DoorsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(door: DoorDTO) {
            ItemDoorBinding.bind(itemView).apply {
                doorItemName.text = door.name
                doorItemName.setOnClickListener {
                    if (doorItemImageView.isVisible) doorItemImageView.visibility = View.GONE
                    else doorItemImageView.visibility = View.VISIBLE
                }
                doorItemImageView.setOnClickListener {
                    itemClickListener.onItemClick(door)
                }
                if (door.snapshot.isNullOrBlank()) {
                    val urlSnapshot =
                        "https://png.pngtree.com/png-vector/20190820/ourmid/pngtree-no-image-vector-illustration-isolated-png-image_1694547.jpg"
                    Picasso.get().load(urlSnapshot).into(doorItemImageView)
                } else {
                    val urlSnapshot: String = door.snapshot
                    Picasso.get().load(urlSnapshot).into(doorItemImageView)
                }
            }
        }
    }
}