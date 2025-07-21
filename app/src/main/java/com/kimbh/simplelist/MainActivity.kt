@file:OptIn(ExperimentalMaterial3Api::class)

package com.kimbh.simplelist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.kimbh.simplelist.presentation.compose.DocumentDetail
import com.kimbh.simplelist.presentation.compose.SearchInputBox
import com.kimbh.simplelist.presentation.compose.SearchInputBoxPreview
import com.kimbh.simplelist.presentation.viewmodel.MainViewModel
import com.kimbh.simplelist.ui.theme.SimpleListTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.net.toUri
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            SimpleListTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main(viewmodel: MainViewModel = hiltViewModel()) {
    val documents = viewmodel.document.collectAsLazyPagingItems()

    var isRefreshing by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(documents.loadState.refresh) {
        if (isRefreshing && documents.loadState.refresh !is LoadState.Loading) {
            isRefreshing = false
        }
    }

    Column {
        SearchInputBox {
            viewmodel.search(it)
        }
        PullToRefreshBox(
            isRefreshing = isRefreshing,
            onRefresh = {
                isRefreshing = true
                documents.refresh()
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(documents.itemCount) { index ->
                    documents[index]?.let {
                        DocumentDetail(it) {
                            Intent(Intent.ACTION_VIEW, it.doc_url.toUri()).run {
                                context.startActivity(this)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainPreview() {
    Column {
        SearchInputBoxPreview()
    }
}