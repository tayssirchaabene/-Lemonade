package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                LemonTextAndImage(
                    text= stringResource(R.string.lemon_select),
                    imageRes = R.drawable.lemon_tree,
                    contentDescription = stringResource(R.string.lemon_tree_content_description),
                    onImageClick = { currentStep = 2 }
                )
            }
            2 -> {
                LemonTextAndImage(
                    text = stringResource(R.string.lemon_squeeze),
                    imageRes = R.drawable.lemon_squeeze,
                    contentDescription = stringResource(R.string.lemon_content_description),
                    onImageClick = { currentStep = 3 }
                )
            }
            3 -> {
                LemonTextAndImage(
                    text = stringResource(R.string.lemon_drink),
                    imageRes = R.drawable.lemon_drink,
                    contentDescription = stringResource(R.string.lemonade_content_description),
                    onImageClick = { currentStep = 4 }
                )
            }
            4 -> {
                LemonTextAndImage(
                    text = stringResource(R.string.lemon_empty_glass),
                    imageRes = R.drawable.lemon_restart,
                    contentDescription = stringResource(R.string.empty_glass_content_description),
                    onImageClick = { currentStep = 1 }
                )
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    text: String,
    imageRes: Int,
    contentDescription: String,
    onImageClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = contentDescription,
            modifier = Modifier
                .wrapContentSize()
                .clickable { onImageClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
