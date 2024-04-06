package com.compose.ui.architecture.coordinator.userlist

sealed interface UserListAction {

    data class OpenDetail(
        val user: User
    ): UserListAction

    object Back: UserListAction
}