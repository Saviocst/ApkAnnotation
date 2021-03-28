package com.example.apkanotation.ui.annotation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apkanotation.R
import com.example.apkanotation.repository.AnnotationRepository
import kotlinx.coroutines.launch

class AnnotationViewModel(private val repository: AnnotationRepository) : ViewModel() {

    private val _annotationStateEventData = MutableLiveData<AnnotationState>()
    val annotationStateEventData: LiveData<AnnotationState>
    get() = _annotationStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
    get() = _messageEventData

    fun addAnnotation(name: String, annotation: String) = viewModelScope.launch {

        try {
            val id = repository.insertAnnotation(name, annotation)
            if (id > 0){
                _annotationStateEventData.value = AnnotationState.Inserted
                _messageEventData.value = R.string.annotation_inserted
            }
        }catch (aviso: Exception){
            _messageEventData.value = R.string.annotation_error
            Log.e(TAG, aviso.toString())
        }
    }

    sealed class AnnotationState{
        object Inserted: AnnotationState()
    }

    companion object{
        private val TAG = AnnotationViewModel::class.java.simpleName
    }

}