package com.compose.ui.architecture.coordinator.userdetail

import androidx.lifecycle.ViewModel
import com.compose.ui.architecture.coordinator.nav.UserCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val coordinator: UserCoordinator
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<UserDetailState> = MutableStateFlow(UserDetailState())

    val stateFlow: StateFlow<UserDetailState> = _stateFlow.asStateFlow()

    fun action(action: UserDetailAction) {
        when (action) {
            UserDetailAction.Back -> {
                coordinator.backClick()
            }

            is UserDetailAction.Init -> {
                _stateFlow.value = _stateFlow.value.copy(user = action.user)
            }
        }
    }
}