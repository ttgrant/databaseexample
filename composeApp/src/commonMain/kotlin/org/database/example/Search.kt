package org.database.example

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun Search() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        var expandedDropdown: SearchFilters? by remember { mutableStateOf(null) }

        Text(
            modifier = Modifier.padding(bottom = 32.dp),
            text = "Search Vehicles",
            fontSize = 32.sp
        )
        Row {
            SearchFilters.entries.forEach { filter ->
                FilterDropdown(expandedDropdown, filter) {
                    expandedDropdown = it
                }
            }
            Button(
                onClick = {},
                content = {
                    Text("Search")
                }
            )
        }
    }
}

@Composable
private fun RowScope.FilterDropdown(
    expandedDropdown: SearchFilters?,
    filter: SearchFilters,
    setExpandedDropdown: (SearchFilters?) -> Unit,
) {
    BoxWithConstraints(modifier = Modifier.weight(1f)) {
        OutlinedTextField(
            modifier = Modifier
                .clickable {
                    setExpandedDropdown(filter)
                }
                .padding(horizontal = 4.dp),
            value = filter.name,
            onValueChange = {},
            enabled = false,
            maxLines = 1,
        )
        DropdownMenu(
            modifier = Modifier.padding(horizontal = 8.dp),
            offset = DpOffset(x = 0.dp, y = this@BoxWithConstraints.minHeight),
            scrollState = rememberScrollState(),
            expanded = filter == expandedDropdown,
            onDismissRequest = { setExpandedDropdown(null) },
            properties = PopupProperties(),
            content = {
                dropDownMenuItems.forEach { dropDownItem ->
                    DropdownMenuItem(
                        content = {
                            Text(text = dropDownItem, fontSize = 20.sp)
                        },
                        onClick = { setExpandedDropdown(null) }
                    )
                }
            }
        )
    }
}

val dropDownMenuItems = List(10) { index -> "Item: $index" }


enum class SearchFilters {
    Color,
    Manufacturer,
    Vehicle_type,
    Year,
    Fuel_type,
}