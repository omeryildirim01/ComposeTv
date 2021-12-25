package com.yildirimomer.composetv.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.yildirimomer.domain.entity.NetworkMovie

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
@Composable
fun GridItem(movie: NetworkMovie) {
    GridItem(posterPath = movie.posterUrl, title = movie.title, desc = movie.overview)
}

@Composable
fun GridItem(posterPath: String, title: String, desc: String) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            shape = RoundedCornerShape(6.dp),
            elevation = 4.dp,
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 8.dp, 0.dp, 0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier
                            .size(120.dp),
                        alignment = Alignment.Center,
                        painter = rememberImagePainter(
                            data = posterPath,
                            builder = {
                                scale(Scale.FILL)
                                transformations(CircleCropTransformation())
                            }
                        ),
                        contentDescription = ""
                    )
                }
                Column(modifier = Modifier.fillMaxWidth().padding(top = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        maxLines = 2,
                        modifier = Modifier.padding(6.dp)
                    )
                }
                if (desc.isNotEmpty()) {
                    Text(
                        modifier = Modifier.padding(6.dp),
                        text = desc,
                        maxLines = 2,
                        fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(Modifier.padding(8.dp))
            }
        }
    }
}
