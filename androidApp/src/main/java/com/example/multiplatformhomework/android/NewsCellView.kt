package com.example.multiplatformhomework.android

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import org.openapitools.client.models.*

@Composable
fun NewsCellView(context: Context, info: NewsInfo) : Unit {
    Card(
        backgroundColor = Color.White,
        elevation = Dp(2F),
        modifier = Modifier
            .padding(all = 16.dp)
            .clickable {
                //cardViewCallBack(context, user)
            }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)) {
            info.title?.let { Text(text = it,
                modifier = Modifier.padding(all = 4.dp),
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                color = Color.Black) }
            info.description?.let { Text(text = it,
                modifier = Modifier.padding(all = 4.dp),
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                color = Color.Blue) }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MultiplatformHomeworkTheme {
//        NewsCellView() // TODO: Add example extension
//    }
//}