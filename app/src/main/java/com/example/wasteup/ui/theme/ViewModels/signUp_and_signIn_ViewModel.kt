package com.example.wasteup.ui.theme.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class signUp_and_signIn_ViewModel: ViewModel() {
    private val _state = MutableStateFlow(true)
    val state = _state.asStateFlow()

    fun onClickButton(result: Boolean){
        _state.update{it.not()
        }
    }

    fun resetState(){
        _state.update { it  }
    }
}

