package com.glovoapp.uabformacions.dogapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glovoapp.uabformacions.dogapi.api.BreedsAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsViewModel @Inject constructor(
    private val breedsAPI: BreedsAPI,
) : ViewModel() {

    val breeds = MutableStateFlow<List<String>>(emptyList())

    @Inject
    fun init() = viewModelScope.launch {
        breeds.value = breedsAPI.getBreeds().message.flatMap { (breed, subBreeds) ->
            if (subBreeds.isEmpty()) listOf(breed)
            else subBreeds.map { "$breed/$it" }
        }
    }

}
