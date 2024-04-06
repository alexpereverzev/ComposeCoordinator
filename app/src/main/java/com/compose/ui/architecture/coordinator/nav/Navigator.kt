package com.compose.ui.architecture.coordinator.nav

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.ui.architecture.coordinator.userdetail.UserDetailRoute
import com.compose.ui.architecture.coordinator.userlist.User
import com.compose.ui.architecture.coordinator.userlist.UserListRoute

class Navigator() {
    private lateinit var navController: NavHostController
    private var user: User? = null
    var context: Activity? = null

    fun showUserDetailScreen(user: User) {
        this.user = user
        navController.navigate(NavigationState.Detail.name)
    }

    fun showUserLists() {
        user = null
        navController.navigate(NavigationState.List.name)
    }

    fun close() {
        context?.finish()
    }

    @Composable
    fun InitNavigation() {
        navController = rememberNavController()
        context = LocalContext.current as Activity
        NavHost(
            navController,
            startDestination = NavigationState.List.name
        ) {
            composable(
                NavigationState.List.name
            ) {
                UserListRoute()
            }
            composable(NavigationState.Detail.name) {
                user?.let {
                    UserDetailRoute(it)
                }
            }
        }
    }
}