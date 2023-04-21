package com.sage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.sage.ui.theme.AndroidcomposelatestTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AndroidcomposelatestTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting("Android")
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {

  var openBottomSheet by rememberSaveable { mutableStateOf(false) }
  var skipPartiallyExpanded by remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()
  val bottomSheetState = rememberSheetState()

// App content
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Row(
      Modifier.toggleable(
        value = skipPartiallyExpanded,
        role = Role.Checkbox,
        onValueChange = { checked -> skipPartiallyExpanded = checked }
      )
    ) {
      Checkbox(checked = skipPartiallyExpanded, onCheckedChange = null)
      Spacer(Modifier.width(16.dp))
      Text("Skip partially expanded State")
    }
    Button(onClick = { openBottomSheet = !openBottomSheet }) {
      Text(text = "Show Bottom Sheet")
    }
  }

// Sheet content
  if (openBottomSheet) {
    ModalBottomSheet(
      onDismissRequest = { openBottomSheet = false },
      sheetState = bottomSheetState,
    ) {
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(
          // Note: If you provide logic outside of onDismissRequest to remove the sheet,
          // you must additionally handle intended state cleanup, if any.
          onClick = {
            scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
              if (!bottomSheetState.isVisible) {
                openBottomSheet = false
              }
            }
          }
        ) {
          Text("Hide Bottom Sheet")
        }
      }
      LazyColumn {
        items(50) {
          ListItem(
            headlineText = { Text("Item $it") },
            leadingContent = {
              Icon(
                Icons.Default.Favorite,
                contentDescription = "Localized description"
              )
            }
          )
        }
      }
    }
  }
}