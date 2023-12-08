package com.example.composearticleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticleapp.ui.theme.ComposeArticleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                   BannerImage(
                       headingText = stringResource(R.string.heading_text),
                       paragraphFirstText = stringResource(R.string.paragraph_first_text),
                       paragraphSecondText = stringResource(R.string.paragraph_second_text)
                       )
                }
            }
        }
    }
}

@Composable
fun BannerImage(
    headingText: String,
    paragraphFirstText: String,
    paragraphSecondText: String,
){
    val image = painterResource(id = R.drawable.bg_compose_background)

    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        HeadingArticle(
            headingText = headingText ,
            paragraphFirstText = paragraphFirstText,
            paragraphSecondText = paragraphSecondText
        )
    }

}

@Composable
fun HeadingArticle(
    headingText: String,
    paragraphFirstText: String,
    paragraphSecondText: String,
    ){
    Column {
        Text(
            text = headingText,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        ContentArticle(
            paragraphFirst = paragraphFirstText,
            paragraphSecond = paragraphSecondText
        )

    }
}

@Composable
fun ContentArticle(paragraphFirst: String, paragraphSecond: String){
    Column {
        Text(
            text = paragraphFirst,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
            )
        Text(
            text = paragraphSecond,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)

        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleAppTheme {
       BannerImage(
           headingText = "Jetpack Compose tutorial",
           paragraphFirstText = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates Ul development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
           paragraphSecondText = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app's Ul programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI's construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
       )
    }
}