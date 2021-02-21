package com.badsha.errormessagepopup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

enum class State {
	COLLAPSED, EXPANDED
}

object LayoutShapes {
	val collapsedShape = RoundedCornerShape(15.dp)
	val expandedShape = RoundedCornerShape(topLeft = 15.dp, topRight = 15.dp)
}

@Composable fun ErrorPopup() {
	ConstraintLayout(
		modifier = Modifier
			.fillMaxSize()
	) {
		var state by remember { mutableStateOf(State.COLLAPSED) }
		val layout = createRef()
		
		Box(modifier = Modifier
			.fillMaxSize()
			.background(Color(0x80000000))
		)
		
		Column(
			modifier = Modifier
				.constrainAs(layout) {
					width = Dimension.fillToConstraints
					bottom.linkTo(parent.bottom, 10.dp)
					start.linkTo(parent.start, 10.dp)
					end.linkTo(parent.end, 10.dp)
				}
//				.padding(10.dp)
				.clip(LayoutShapes.collapsedShape)
				.background(Color.White)
				.padding(5.dp)
		) {
			when (state) {
				State.COLLAPSED ->
					CollapsedView(
						onClick = {
							state = State.EXPANDED
						}
					)
				State.EXPANDED -> { }
			}
		}
	}
}

@Preview
@Composable fun PreviewCollapsedView() {
//	CollapsedView(onClick = { /*TODO*/ })
	ErrorPopup()
}


@Composable fun CollapsedView(
	onClick: () -> Unit
) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Center
	) {
		Box(
			modifier = Modifier
				.clip(RoundedCornerShape(5.dp))
				.background(Color(0xFFFDB8B8))
				.padding(5.dp)
				.weight(1f)
		) {
			Text("An Error Occurred")
		}
		
		Spacer(modifier = Modifier.width(5.dp))
		
		IconButton(onClick = onClick) {
			Icons.Outlined.Share
		}
	}
}