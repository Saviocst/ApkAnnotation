package com.example.apkanotation.ui.annotation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apkanotation.R

class AnnotationFragment : Fragment() {

    private lateinit var viewModel: AnnotationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.annotation_fragment, container, false)
    }


}