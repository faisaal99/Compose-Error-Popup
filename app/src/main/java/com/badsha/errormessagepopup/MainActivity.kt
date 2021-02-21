package com.badsha.errormessagepopup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import com.badsha.errormessagepopup.ui.theme.ErrorMessagePopUpTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.badsha.errormessagepopup.ui.components.ErrorPopup

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ErrorMessagePopUpTheme(false) {
				MainActivityUI()
			}
		}
	}
	
	@Composable fun MainActivityUI() {
		var isErrorPopUpVisible by remember { mutableStateOf(false) }
		
		Scaffold(
			topBar = {
				TopAppBar(
					title = { Text("Oh no! 😱") }
				)
			}
		){
			ConstraintLayout(
				modifier = Modifier.fillMaxSize()
			) {
				val btn = createRef()
				
				if(isErrorPopUpVisible) {
					ErrorPopup()
				}
				
				Button(
					onClick = {
						isErrorPopUpVisible = true
					}
				) {
					Text("Simulate Error")
				}
			}
		}
	}
}