package com.example.myapplication

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.ui.theme.scrollfun


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var strMes = remember {
                mutableStateOf(
                    this@MainActivity.getString(R.string.app_name)
                )
            }
            var stateFlag = remember { mutableStateOf(false) }
            val scrollState = rememberScrollState()
            val scrolled = remember { scrollState.value }
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState) ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = strMes.value,
                    color = Color.Cyan,
                    fontSize = 50.sp
                )

                Image(
                    painter = painterResource(id = R.drawable.image2),

                    contentDescription = "Image2"
                )

                Row(
                )
                {
                    Image(

                        painter = painterResource(id = R.drawable.image),
                        contentDescription = "Image1",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .width(205.dp)
                            .clip(RoundedCornerShape(20.dp))

                    )

                    Image(
                        painter = painterResource(id = R.drawable.image1),

                        contentDescription = "Image2",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .width(205.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                }

                //make a 2x2 photo grid and call it a day.
                Row(
                )
                {
                    Image(

                        painter = painterResource(id = R.drawable.image6),
                        contentDescription = "Image1",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(205.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.image5),

                        contentDescription = "Image2",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(205.dp)
                    )
                }

                Row(
                )
                {
                    Image(

                        painter = painterResource(id = R.drawable.image4),
                        contentDescription = "Image1",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(205.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.image3),

                        contentDescription = "Image2",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(205.dp)
                    )
                }
                Text(text = "Now text showed:" + strMes.value,
                    color = Color.Blue,
                    fontSize = 20.sp
                )


                Button(onClick = {
                    if (stateFlag.value) {
                        strMes.value = this@MainActivity.getString(R.string.app_name1)
                        stateFlag.value = false
                    } else {
                        strMes.value = this@MainActivity.getString(R.string.app_name)
                        stateFlag.value = true
                    }
                }) { Text(text = "Swap Message") }

            }
        }
    }
}

