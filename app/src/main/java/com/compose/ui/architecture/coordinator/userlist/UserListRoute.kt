package com.compose.ui.architecture.coordinator.userlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun UserListRoute(
    coordinator: UserListCoordinator = rememberUserListCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(UserListState(isLoading = true))

    // UI Actions
    val actions = rememberUserListActions(coordinator)

    // UI Rendering
    UserListScreen(uiState, actions)
}


@Composable
fun rememberUserListActions(coordinator: UserListCoordinator): UserListActions {
    return remember(coordinator) {
        UserListActions(
            onClick = coordinator.viewModel::action
        )
    }
}