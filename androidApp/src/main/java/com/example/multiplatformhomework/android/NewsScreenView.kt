package com.example.multiplatformhomework.android

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import com.example.multiplatformhomework.network.models.*
import org.w3c.dom.NodeList

@Composable
fun NewsScreenView(context: Context, viewModel: NewsViewModel) {
    val news = viewModel.news.observeAsState(initial = listOf())
    LaunchedEffect("OnStart") {
        viewModel.fetchNext()
    }
    LazyColumn(modifier = Modifier
        .fillMaxHeight()
    ) {
        items(items = news.value, itemContent = { item ->
            val isLastItem = news.value.last().uuid == item.uuid
            NewsCellView(context, item)
            if (isLastItem && news.value.count() < viewModel.total) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .onGloballyPositioned {
                            if (!viewModel.isLoading) {
                                viewModel.fetchNext()
                            }
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        })
    }
}