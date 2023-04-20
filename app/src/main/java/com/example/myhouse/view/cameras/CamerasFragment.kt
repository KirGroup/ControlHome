package com.example.myhouse.view.cameras

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse.databinding.FragmentCamerasBinding
import com.example.myhouse.model.AppStateCameras
import com.example.myhouse.utils.ViewBindingFragment
import com.example.myhouse.viewmodel.CamerasViewModel

class CamerasFragment : ViewBindingFragment<FragmentCamerasBinding>(FragmentCamerasBinding::inflate) {

    private lateinit var viewModel: CamerasViewModel
    private val adapter: CamerasAdapter by lazy { CamerasAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CamerasViewModel::class.java]
        viewModel.getLiveData().observe(viewLifecycleOwner) { renderData(it) }
        viewModel.getCamerasFromServer()
    }

    private fun renderData(appStateCameras: AppStateCameras) {
        when (appStateCameras) {
            is AppStateCameras.Success -> {
                binding.cameraRecyclerView.adapter = adapter
                adapter.setData(appStateCameras.camerasData)
            }
            is AppStateCameras.Loading -> {
                //will add the loader
            }
            is AppStateCameras.Error -> {
            }
        }
    }

    companion object {
        fun newInstance(): CamerasFragment {
            return CamerasFragment()
        }
    }
}