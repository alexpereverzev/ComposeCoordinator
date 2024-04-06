package com.compose.ui.architecture.coordinator.userlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.ui.architecture.coordinator.userlist.User

@Composable
fun UserCard(
    user: User,
    modifier: Modifier = Modifier,
    onClick: (User) -> Unit = {}
) {
    Card(modifier.clickable {
        onClick.invoke(user)
    }) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = user.name
        )
    }
}

@Preview(name = "UserCard")
@Composable
private fun PreviewUserCard() {
    UserCard(user = User("name", "description"))
}