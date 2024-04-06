package com.compose.ui.architecture.coordinator.userdetail

import com.compose.ui.architecture.coordinator.userlist.User

sealed interface UserDetailAction {

    data class Init(
        val user: User
    ): UserDetailAction

    object Back: UserDetailAction
}