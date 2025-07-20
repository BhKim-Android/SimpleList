package com.kimbh.simplelist.presentation.compose

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kimbh.simplelist.domain.model.Document


@Composable
fun DocumentDetail(document: Document, onClick: () -> Unit) {
    Column(modifier = Modifier.clickable {
        onClick()
    }) {
        Box {
            AsyncImage(
                model = document.image_url, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.6f)
                    .background(color = Color.Gray),
                contentScale = ContentScale.Crop
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = document.thumbnail_url,
                    contentDescription = "",
                    modifier = Modifier
                        .width(40.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = document.display_sitename,
                    style = TextStyle(color = Color.White)
                )
            }
        }
        Text(text = document.datetime)
    }
}

@Preview(showBackground = true)
@Composable
fun DocumentDetailPreview() {
    DocumentDetail(
        Document(
            collection = "collection",
            thumbnail_url = "thumbnail_url",
            image_url = "image_url",
            display_sitename = "display_sitename",
            doc_url = "doc_url",
            datetime = "datetime"
        ), {}
    )
}