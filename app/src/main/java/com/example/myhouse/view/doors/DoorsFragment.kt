package com.example.myhouse.view.doors

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.model.AppStateDoors
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.utils.ViewBindingFragment
import com.example.myhouse.view.doorDetails.DoorDetailsFragment
import com.example.myhouse.viewmodel.DoorsViewModel

class DoorsFragment : ViewBindingFragment<FragmentDoorsBinding>(FragmentDoorsBinding::inflate) {

    private lateinit var viewModel: DoorsViewModel
    private val adapter: DoorsAdapter =
        DoorsAdapter(object : OnListItemClickListener {

            override fun onItemClick(door: DoorDTO) {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, DoorDetailsFragment.newInstance(Bundle().apply {
                        putParcelable(DoorDetailsFragment.BUNDLE_EXTRA, door)
                    }))
                    ?.addToBackStack("")
                    ?.commitAllowingStateLoss()
            }
        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DoorsViewModel::class.java]
        viewModel.getLiveData().observe(viewLifecycleOwner) { renderData(it) }
        viewModel.getDoorsFromServer()
    }

    private fun renderData(appStateDoors: AppStateDoors) {
        when (appStateDoors) {
            is AppStateDoors.Success -> {
                adapter.setData(appStateDoors.doorsData)
                binding.doorsRecyclerView.adapter = adapter
            }
            is AppStateDoors.Loading -> {
            }
            is AppStateDoors.Error -> {

            }
        }
    }

    companion object {
        fun newInstance(): DoorsFragment {
            return DoorsFragment()
        }
    }
}