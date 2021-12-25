package com.yildirimomer.composetv.ui.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yildirimomer.composetv.ui.common.NavigationItem
import com.yildirimomer.composetv.ui.nowplaying.NowPlayingScreen
import com.yildirimomer.composetv.ui.popular.PopularScreen
import com.yildirimomer.composetv.ui.theme.SpeechRed
import com.yildirimomer.composetv.ui.upcoming.UpcomingScreen
import com.yildirimomer.composetv.R

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
    ) {
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavigationItem.NowPlaying.route) {
        composable(NavigationItem.NowPlaying.route) {
            NowPlayingScreen()
        }
        composable(NavigationItem.Popular.route) {
            PopularScreen()
        }
        composable(NavigationItem.Upcoming.route) {
            UpcomingScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val bottomNavigationItems = listOf(
        NavigationItem.NowPlaying,
        NavigationItem.Popular,
        NavigationItem.Upcoming
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        bottomNavigationItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.route) },
                label = { Text(text = item.route) },
                selectedContentColor = SpeechRed,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                    }
                }
            )
        }
    }
}
