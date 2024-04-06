package com.compose.ui.architecture.coordinator.userlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.ui.architecture.coordinator.userlist.components.CircleProgress
import com.compose.ui.architecture.coordinator.userlist.components.UserCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    state: UserListState,
    actions: UserListActions,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "User List")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        actions.onClick.invoke(UserListAction.Back)
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
            )
        }, content = { padding ->

            if (state.isLoading) {
                CircleProgress()
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 56.dp)
                ) {
                    items(
                        count = state.items.size,
                        itemContent = {
                            UserCard(user = state.items[it],
                                modifier = Modifier.fillMaxWidth(),
                                onClick = { user ->
                                    actions.onClick.invoke(UserListAction.OpenDetail(user))
                                })
                        })
                }
            }
        })
}

@Composable
@Preview(name = "UserList")
private fun UserListScreenPreview() {
    UserListScreen(
        state = UserListState(),
        actions = UserListActions()
    )
}

