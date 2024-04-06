package com.compose.ui.architecture.coordinator.userlist

import androidx.lifecycle.ViewModel
import com.compose.ui.architecture.coordinator.nav.UserCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val coordinator: UserCoordinator
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<UserListState> =
        MutableStateFlow(UserListState(isLoading = true))

    val stateFlow: StateFlow<UserListState> = _stateFlow.asStateFlow()

    init {
        val items: ArrayList<User> = ArrayList()
        repeat(100) {
            items.add(
                User(
                    name = "User name $it",
                    description = "description $it"
                )
            )
        }
        _stateFlow.value = _stateFlow.value.copy(
            isLoading = false,
            items = items
        )
    }

    fun action(actions: UserListAction) {
        when (actions) {
            is UserListAction.OpenDetail -> {
                coordinator.openUserDetail(actions.user)
            }

            UserListAction.Back -> {
                coordinator.backClick()
            }
        }
    }
}