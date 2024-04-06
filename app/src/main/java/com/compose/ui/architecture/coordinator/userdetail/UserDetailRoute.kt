package com.compose.ui.architecture.coordinator.userdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.compose.ui.architecture.coordinator.userlist.User

@Composable
fun UserDetailRoute(
    user: User,
    coordinator: UserDetailCoordinator = rememberUserDetailCoordinator(user)
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(UserDetailState())

    // UI Actions
    val actions = rememberUserDetailActions(coordinator)

    // UI Rendering
    UserDetailScreen(uiState, actions)
}


@Composable
fun rememberUserDetailActions(coordinator: UserDetailCoordinator): UserDetailActions {
    return remember(coordinator) {
        UserDetailActions(
            onClick = {
                coordinator.viewModel.action(UserDetailAction.Back)
            }
        )
    }
}