package com.example.lazycolumn_project

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.lazycolumn_project.ui.theme.LazyColumn_projectTheme
import com.example.lazycolumn_project.utils.DataProvider
import com.example.lazycolumn_project.utils.UserModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn_projectTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}


@Composable
fun MainContent() {
    Surface(color = Color.Gray) {
        Scaffold(backgroundColor = Color.White,
            topBar = { MainAppBar() }
        ) {
            UserListView(userModels = DataProvider.userList )
        }
    }
}

@Composable
fun UserView(userModel: UserModel) {
    val typography = MaterialTheme.typography

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(12.dp)

    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ProfileImg(imgUrl = userModel.userPhoto)

            Column() {
                Text(
                    text = userModel.userName,
                    style = typography.subtitle1
                )

                userModel.userEmail?.let {
                    Text(
                        text = it,
                        style = typography.subtitle2
                    )
                }

                userModel.userPhone?.let {
                    Text(
                        text = it,
                        style = typography.subtitle2
                    )
                }
            }
        }
    }

}

@Composable
fun MainAppBar() {
    TopAppBar(elevation = 10.dp,
        backgroundColor = Color.Yellow ,
        modifier = Modifier.height(50.dp)
    ) {
         Text(
             text = stringResource(id = R.string.app_name),
             modifier = Modifier
                 .padding(8.dp)
                 .align(Alignment.CenterVertically),
             fontSize = 20.sp,
             fontWeight = FontWeight.Black

         )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun ProfileImg(imgUrl: String, modifier: Modifier = Modifier) {

    val bitmap : MutableState<Bitmap?> = mutableStateOf(null)

    val imageModifier = modifier
        .size(50.dp, 50.dp)
        .clip(CircleShape)

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(imgUrl)
        .into(object: CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmap.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }

        })

    bitmap.value?.asImageBitmap()?.let { fetchedBitmap ->
        Image(bitmap = fetchedBitmap,
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = imageModifier
        )
    } ?: Image(painter = painterResource(id = R.drawable.ic_baseline_person_24),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = imageModifier
    )

}

@Composable
fun UserListView(userModels: List<UserModel>) {
    LazyColumn() {
        items(userModels) { UserView(it) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumn_projectTheme {
        MainContent()
    }
}