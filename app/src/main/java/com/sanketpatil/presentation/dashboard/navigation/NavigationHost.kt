
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sanketpatil.presentation.dashboard.navigation.DashboardProductScreen


@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {
        composable(NavRoutes.Home.route) {
            DashboardProductScreen()
        }

        composable(NavRoutes.Search.route) {

        }

        composable(NavRoutes.Favorites.route) {

        }
    }
}