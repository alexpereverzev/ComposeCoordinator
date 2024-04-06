package com.compose.ui.architecture.coordinator.userlist


/**
 * UI State that represents UserListScreen
 **/
data class UserListState(
    val isLoading: Boolean = true,
    val items: List<User> = emptyList()
)

/**
 * UserList Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class UserListActions(
    val onClick: (UserListAction) -> Unit = {}
)