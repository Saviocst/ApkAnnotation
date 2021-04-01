package com.example.apkanotation.ui.annotationlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.apkanotation.R
import com.example.apkanotation.data.db.DataBaseSv
import com.example.apkanotation.data.db.dao.AnnotationDAO
import com.example.apkanotation.data.db.entity.AnnotationEntity
import com.example.apkanotation.repository.AnnotationRepository
import com.example.apkanotation.repository.DataBaseDataSource
import com.example.apkanotation.ui.annotation.AnnotationViewModel
import kotlinx.android.synthetic.main.annotation_list_fragment.*

class AnnotationListFragment : Fragment(R.layout.annotation_list_fragment) {

    private val viewModel: AnnotationListViewModel by viewModels {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                val annotationDAO: AnnotationDAO = DataBaseSv.getInstance(requireContext()).annotationDAO

                val repository: AnnotationRepository = DataBaseDataSource(annotationDAO)
                return AnnotationListViewModel(repository) as T
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        annotationViewModelEvents()
        configureViewListener()

    }

    private fun annotationViewModelEvents() {

        viewModel.allAnnotationEvent.observe(viewLifecycleOwner, { allAnnotation ->

            val annotationListAdapter = AnnotationListAdapter(allAnnotation).apply {
                onItemClick = { annotation ->

                    //Vídeo 13 - entender
                    findNavController().navigate()
                }
            }

            rv_list_main.run {
                setHasFixedSize(true)
                adapter = annotationListAdapter
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAnnotation()
    }

    private fun configureViewListener(){
        btn_add.setOnClickListener {
            findNavController().navigate(R.id.annotationFragment)
        }
    }

}