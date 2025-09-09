package com.chanpyaung.themarketplace.ui.discover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chanpyaung.themarketplace.domain.models.Product
import com.chanpyaung.themarketplace.domain.usecase.GetListingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class DiscoverUiState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String? = null,
    val hasMorePages: Boolean = true
)

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val getListingUseCase: GetListingUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DiscoverUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            getListingUseCase()
                .onSuccess {
                    _uiState.value = DiscoverUiState(products = it, isLoading = false)
                }
                .onFailure {
                    _uiState.value = DiscoverUiState(isLoading = false, errorMessage = "Something went wrong!")
                }
        }
    }
}