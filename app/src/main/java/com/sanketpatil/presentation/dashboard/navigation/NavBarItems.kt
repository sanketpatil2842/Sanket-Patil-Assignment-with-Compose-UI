
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            title = "Search",
            image = Icons.Filled.Search,
            route = "search"
        ),
        BarItem(
            title = "Favorites",
            image = Icons.Filled.Favorite,
            route = "favorites"
        )
    )
}