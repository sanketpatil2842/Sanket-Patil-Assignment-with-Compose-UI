

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Search : NavRoutes("search")
    object Favorites : NavRoutes("favorites")
}