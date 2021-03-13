/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.home.HomeScreen
import com.example.androiddevchallenge.login.LoginScreen
import com.example.androiddevchallenge.welcome.WelcomeScreen

internal enum class Destination {
    WelcomeScreen, LoginScreen, HomeScreen
}

internal fun NavHostController.navigate(destination: Destination) = navigate(destination.name) {
    launchSingleTop = true
}

@Composable
internal fun AppNavHost(
    navController: NavHostController,
) = NavHost(
    navController = navController,
    startDestination = Destination.WelcomeScreen
) {
    composable(Destination.WelcomeScreen) {
        WelcomeScreen(onLogIn = { navController.navigate(Destination.LoginScreen) })
    }
    composable(Destination.LoginScreen) {
        LoginScreen(onLoggedIn = { navController.navigate(Destination.HomeScreen) })
    }
    composable(Destination.HomeScreen) {
        HomeScreen()
    }
}

@Composable
private fun NavHost(
    navController: NavHostController,
    startDestination: Enum<*>,
    route: Enum<*>? = null,
    builder: NavGraphBuilder.() -> Unit
): Unit =
    androidx.navigation.compose.NavHost(navController, startDestination.name, route?.name, builder)

private fun NavGraphBuilder.composable(
    route: Enum<*>,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) = composable(route.name, arguments, deepLinks, content)
