package com.compose.ui.architecture.coordinator.nav

import com.compose.ui.architecture.coordinator.userlist.User

class UserCoordinator(
    private val navigator: Navigator
) {
    private val state: ArrayDeque<NavigationState> = ArrayDeque<NavigationState>().apply {
        add(NavigationState.List)
    }

    fun openUserDetail(user: User) {
        state.add(NavigationState.Detail)
        navigator.showUserDetailScreen(user)
    }

    fun backClick() {
        if (state.first() == NavigationState.Detail) {
            state.removeLast()
            navigator.showUserLists()
        } else {
            navigator.close()
        }
    }

}

enum class NavigationState {

    List,
    Detail,

}