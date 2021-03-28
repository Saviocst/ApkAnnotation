package com.example.apkanotation.ui.annotation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apkanotation.R
import com.example.apkanotation.data.db.DataBaseSv
import com.example.apkanotation.data.db.dao.AnnotationDAO
import com.example.apkanotation.extention.hideKeyBoard
import com.example.apkanotation.repository.AnnotationRepository
import com.example.apkanotation.repository.DataBaseDataSource
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.annotation_fragment.*

class AnnotationFragment : Fragment(R.layout.annotation_fragment) {

//lateinit var inputName: EditText
//lateinit var inputRemember: EditText

    private val viewModel: AnnotationViewModel by viewModels {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                val annotationDAO: AnnotationDAO = DataBaseSv.getInstance(requireContext()).annotationDAO

                val repository: AnnotationRepository = DataBaseDataSource(annotationDAO)
                return AnnotationViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvents()
        setListeners()
    }


    private fun observeEvents() {
        viewModel.annotationStateEventData.observe(viewLifecycleOwner){annotationState ->
            when (annotationState) {
                is AnnotationViewModel.AnnotationState.Inserted -> {
                    clearFields()
                    hideKeyBoard()
                }

            }
        }

        viewModel.messageEventData.observe(viewLifecycleOwner) {stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }


    private fun clearFields() {
        input_name.text?.clear()
        input_remember.text?.clear()
    }

    private fun hideKeyBoard() {
        val parentActivity = requireActivity()
        if (parentActivity is AppCompatActivity){
            parentActivity.hideKeyBoard() //Obs Estudar
        }
    }

    private fun setListeners() {
        btn_adicionar.setOnClickListener {
            val name = input_name.text.toString()
            val annotation = input_name.text.toString()
            viewModel.addAnnotation(name, annotation)
        }
    }

    // Video 7 -> Continuar
}