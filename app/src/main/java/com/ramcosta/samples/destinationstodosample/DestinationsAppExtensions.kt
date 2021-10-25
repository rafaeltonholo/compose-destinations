package com.ramcosta.samples.destinationstodosample

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.*

@Composable
fun Destination.DrawerContent(
    isSelected: Boolean,
    onDestinationClick: (Destination) -> Unit
) {
    when (this) {
        FeedDestination,
        GreetingDestination -> {
            Text(
                text = stringResource(id = requireTitle),
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        onDestinationClick(this)
                    },
                fontWeight = if (isSelected) FontWeight.Bold else null
            )
        }
        ProfileScreenDestination,
        GoToProfileConfirmationDestination,
        SettingsDestination,
        ThemeSettingsDestination -> {
        }
    }
}

@get:StringRes
val Destination.requireTitle
    get(): Int {
        return title ?: throw RuntimeException("Destination $this, doesn't contain title")
    }

@get:StringRes
val Destination.title
    get(): Int? {
        return when (this) {
            GreetingDestination -> R.string.greeting_screen
            ProfileScreenDestination -> R.string.profile_screen
            SettingsDestination -> R.string.settings_screen
            FeedDestination -> R.string.feed_screen
            ThemeSettingsDestination -> R.string.theme_settings_screen
            GoToProfileConfirmationDestination -> null
        }
    }