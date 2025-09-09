package com.chanpyaung.themarketplace.ui.discover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverScreen(
    viewModel: DiscoverViewModel = hiltViewModel(),
    onShowSnackbar: (String) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = { Text("Browse") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            ), actions = {
                IconButton(onClick = {
                    onShowSnackbar("Search clicked")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "search"
                    )
                }
                IconButton(onClick = {
                    onShowSnackbar("Shopping cart clicked")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "cart"
                    )
                }
            }, scrollBehavior = scrollBehavior
        )

        when {
            uiState.isLoading && uiState.products.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            !uiState.errorMessage.isNullOrEmpty() && uiState.products.isEmpty() -> {
                Text(
                    text = uiState.errorMessage ?: "Unknown error occurred",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }

            else -> {
                LazyColumn(
                    state = listState,
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    itemsIndexed(uiState.products) { index, product ->
                        ProductItem(product) { clickedProduct ->
                            onShowSnackbar("Tapped on: ${clickedProduct.title}")
                        }
                        if (index < uiState.products.lastIndex) {
                            HorizontalDivider(thickness = 1.dp, color = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DiscoverScreenPreview() {
    DiscoverScreen(onShowSnackbar = {})
}