package com.example.myhouse.view.doorDetails

import android.os.Bundle
import android.view.View
import com.example.myhouse.databinding.FragmentDoorDetailsBinding
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.utils.ViewBindingFragment
import com.squareup.picasso.Picasso

class DoorDetailsFragment :
    ViewBindingFragment<FragmentDoorDetailsBinding>(FragmentDoorDetailsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<DoorDTO>(BUNDLE_EXTRA)?.apply {
            doorBundle = this
        }
        renderData()
    }

    private fun renderData() = with(binding) {
        doorDetailsName.text = doorBundle?.name
        Picasso.get().load(doorBundle?.snapshot).into(doorDetailsSnapshot)
        doorDetailsBackButton.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    private var doorBundle: DoorDTO? = null

    companion object {
        const val BUNDLE_EXTRA = "door"
        fun newInstance(bundle: Bundle): DoorDetailsFragment {
            val fragment = DoorDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}