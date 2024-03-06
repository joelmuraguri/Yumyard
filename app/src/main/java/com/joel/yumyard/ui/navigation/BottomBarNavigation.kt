package com.joel.yumyard.ui.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.joel.yumyard.ui.theme.UzitoTheme

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomBarNavigationList.forEach { destination ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationBarItem(
                selected = selected,
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon!!),
                        contentDescription = stringResource(id = destination.title!!)
                    )
                },
                label = { Text(text = stringResource(id = destination.title!!)) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(Screens.Discover.route)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = orange20,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
//                    selectedTextColor = orange20,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
//                    indicatorColor = MaterialTheme.colorScheme.background.copy(alpha = 0f)
                )
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    UzitoTheme {
        BottomNavigationBar(rememberNavController())
    }
}