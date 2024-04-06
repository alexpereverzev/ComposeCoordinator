package com.compose.ui.architecture.coordinator.userdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.ui.architecture.coordinator.userlist.User

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class UserDetailCoordinator(
    val viewModel: UserDetailViewModel
) {
    val screenStateFlow = viewModel.stateFlow

}

@Composable
fun rememberUserDetailCoordinator(
    user: User,
    viewModel: UserDetailViewModel = hiltViewModel()
): UserDetailCoordinator {
    viewModel.action(UserDetailAction.Init(user))
    return remember(viewModel) {
        UserDetailCoordinator(
            viewModel = viewModel
        )
    }
}