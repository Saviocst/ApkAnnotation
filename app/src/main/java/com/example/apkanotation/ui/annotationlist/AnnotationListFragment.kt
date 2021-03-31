package com.example.apkanotation.ui.annotationlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apkanotation.R
import com.example.apkanotation.data.db.entity.AnnotationEntity
import kotlinx.android.synthetic.main.annotation_list_fragment.*

class AnnotationListFragment : Fragment(R.layout.annotation_list_fragment) {

    private lateinit var viewModel: AnnotationListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val annotationListAdapter = AnnotationListAdapter(
            listOf(
                AnnotationEntity(1, "COMPRAR", "Comprar bateria da moto"),
                AnnotationEntity(2, "JOGO", "Fazer jogo da lotofacil")
            )
        )

        rv_list_main.run {
            setHasFixedSize(true)
            adapter = annotationListAdapter
        }

    }

}