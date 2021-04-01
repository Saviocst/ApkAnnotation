package com.example.apkanotation.ui.annotationlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apkanotation.data.db.entity.AnnotationEntity
import com.example.apkanotation.repository.AnnotationRepository
import kotlinx.coroutines.launch

class AnnotationListViewModel( private val repository: AnnotationRepository) : ViewModel() {

    private val _allAnnotationsEvent = MutableLiveData<List<AnnotationEntity>>()
    val allAnnotationEvent: LiveData<List<AnnotationEntity>>
    get() = _allAnnotationsEvent

    fun getAnnotation() = viewModelScope.launch {
        _allAnnotationsEvent.postValue(repository.getAllAnnotation())
    }
}