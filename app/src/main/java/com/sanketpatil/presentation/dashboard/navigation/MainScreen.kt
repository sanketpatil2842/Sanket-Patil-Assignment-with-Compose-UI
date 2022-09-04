
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = {Text("Sanket Patil Assignment")}, actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Icon",
                    tint = Color.White, modifier = Modifier
                        .clickable {

                        }
                )
            }
        })  },
        content = { NavigationHost(navController = navController) },
        bottomBar = { BottomNavigationBar(navController = navController)}
    )
}