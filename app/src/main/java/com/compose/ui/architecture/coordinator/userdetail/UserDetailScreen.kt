package com.compose.ui.architecture.coordinator.userdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.compose.ui.architecture.coordinator.userlist.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(
    state: UserDetailState,
    actions: UserDetailActions,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "User Detail")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        actions.onClick.invoke()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
            )
        }, content = { padding ->


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = state.user?.name.orEmpty(), fontSize = 24.sp)
                Text(text = state.user?.description.orEmpty(), fontSize = 20.sp)
            }

        }
    )


}

@Composable
@Preview(name = "UserDetail")
private fun UserDetailScreenPreview() {
    UserDetailScreen(
        state = UserDetailState(User("name", "descriptio")),
        actions = UserDetailActions()
    )
}

