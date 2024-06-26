package com.naufalm.haditsar.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ScanViewModel: ViewModel() {
    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    val _detectedText = MutableStateFlow("No text detected")
    val detectedText: StateFlow<String> = _detectedText

    fun scanText(image: InputImage) {
        viewModelScope.launch {
            try {
                val result = recognizer.process(image)
                _detectedText.value = result.toString()
            } catch (e: Exception) {
                _detectedText.value = "Error: ${e.message}"
            }
        }
    }
}