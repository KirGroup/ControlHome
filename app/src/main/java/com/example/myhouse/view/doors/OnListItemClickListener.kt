package com.example.myhouse.view.doors

import com.example.myhouse.model.rest.rest_entites.DoorDTO

interface OnListItemClickListener {
    fun onItemClick(door: DoorDTO)
}