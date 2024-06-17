package com.naufalm.haditsar.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufalm.haditsar.data.ApiService
import com.naufalm.haditsar.data.models.Hadits
import kotlinx.coroutines.launch

class InfoViewModel : ViewModel() {
    var hadistListResponse: List<Hadits> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")
    fun getHaditsList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val haditsList = apiService.getPosts()
                hadistListResponse = haditsList
                Log.d("PRBB", "getHaditsList: $hadistListResponse")
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}