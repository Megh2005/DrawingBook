package com.example.drawingbook.whiteboard

import androidx.compose.ui.geometry.Offset
import com.example.drawingbook.domain.model.DrawingTool
import com.example.drawingbook.domain.model.DrawnPath


data class WhiteboardState(
    val paths: List<DrawnPath> = emptyList(),
    val currentPath: DrawnPath? = null,
    val startingOffset: Offset = Offset.Zero,
    val selectedTool: DrawingTool = DrawingTool.PEN,
    val isDrawingToolsCardVisible: Boolean = false
)