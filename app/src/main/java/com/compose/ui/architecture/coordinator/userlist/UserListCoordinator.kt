package com.compose.ui.architecture.coordinator.userlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class UserListCoordinator(
    val viewModel: UserListViewModel
) {
    val screenStateFlow = viewModel.stateFlow

    fun doStuff() {
        // TODO Handle UI Action
    }
}

@Composable
fun rememberUserListCoordinator(
    viewModel: UserListViewModel = hiltViewModel()
): UserListCoordinator {
    return remember(viewModel) {
        UserListCoordinator(
            viewModel = viewModel
        )
    }
}