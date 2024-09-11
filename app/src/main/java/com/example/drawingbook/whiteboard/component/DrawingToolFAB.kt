package com.example.drawingbook.whiteboard.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.drawingbook.domain.model.DrawingTool

@Composable
fun DrawingToolFAB(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    selectedTool: DrawingTool,
    onClick: () -> Unit
) {
    val imageIcons =
        listOf(DrawingTool.PEN, DrawingTool.HIGHLIGHTER, DrawingTool.LASER_PEN, DrawingTool.ERASER)
    AnimatedVisibility(
        modifier = modifier,
        visible = isVisible,
        enter = slideInVertically(tween(durationMillis = 500)) { h -> h },
        exit = slideOutVertically(tween(durationMillis = 500)) { h -> h }
    ) {
        FloatingActionButton(
            onClick = { onClick() }
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                painter = painterResource(id = selectedTool.resId),
                contentDescription = selectedTool.name,
                tint = if (imageIcons.contains(selectedTool)) {
                    Color.Unspecified
                } else LocalContentColor.current
            )
        }
    }
}