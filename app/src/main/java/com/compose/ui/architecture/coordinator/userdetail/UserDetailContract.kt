package com.compose.ui.architecture.coordinator.userdetail

import com.compose.ui.architecture.coordinator.userlist.User


/**
 * UI State that represents UserDetailScreen
 **/
data class UserDetailState(
    val user: User? = null
)

/**
 * UserDetail Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class UserDetailActions(
    val onClick: () -> Unit = {}
)