package com.naufalm.haditsar.ui.screens.scan_hadits

import android.graphics.Bitmap
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.naufalm.haditsar.R
import com.naufalm.haditsar.viewmodel.ScanViewModel
import io.github.sceneview.ar.ArSceneView
import java.util.concurrent.Executors

@ExperimentalGetImage
@ExperimentalPermissionsApi
@Composable
fun ScanScreen(navController: NavController) {
    val context = LocalContext.current
    val previewView: PreviewView = remember { PreviewView(context) }
    val cameraController = remember { LifecycleCameraController(context) }
    val lifecycleOwner = LocalLifecycleOwner.current
    cameraController.bindToLifecycle(lifecycleOwner)
    cameraController.cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
    previewView.controller = cameraController

    val executor = remember { Executors.newSingleThreadExecutor() }
    val textRecognizer = remember { TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS) }

    var text by rememberSaveable { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
        } else {
            IconButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                onClick = {
                    isLoading = true
                    cameraController.setImageAnalysisAnalyzer(executor) {imageProxy ->
                        imageProxy.image?.let { image ->
                            val img = InputImage.fromMediaImage(
                                image,
                                imageProxy.imageInfo.rotationDegrees
                            )

                            textRecognizer.process(img).addOnCompleteListener { task ->
                                isLoading = false
                                text = if (!task.isSuccessful) task.exception!!.localizedMessage.toString()
                                else task.result.text

                                cameraController.clearImageAnalysisAnalyzer()
                                imageProxy.close()
                            }
                        }
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier.size(54.dp)
                )
            }
        }
    }

    if (text.isNotEmpty()) {
        Dialog(onDismissRequest = { text = ""}) {
            Card(modifier = Modifier.fillMaxWidth(0.8f)) {
                Text(
                    text = text,
                    modifier = Modifier.padding(horizontal = 16.dp).padding(top = 16.dp)
                )
                Button(
                    onClick = { text = ""},
                    modifier = Modifier.align(Alignment.End).padding(16.dp)
                ) {
                    Text(text = "Done")
                }
            }
        }
    }

//    val detectedText = viewModel.detectedText.collectAsState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .weight(1f)
//        ) {
//            val arSceneView = ArSceneView
//            ArSceneView
//        }
//        Spacer(modifier = Modifier.height(15.dp))
//        Button(onClick = {
//            val bitmap = captureBitmapFromArSceneView()
//            val image: InputImage = InputImage.fromBitmap(bitmap, 0)
//            viewModel.scanText(image)
//        }) {
//            Text(text = "Scan Text")
//        }
//        Spacer(modifier = Modifier.height(15.dp))
//        BubbleText(text = detectedText.value)
//    }
}

//fun captureBitmapFromArSceneView(): Bitmap {
//    return Bitmap.createBitmap(1080, 1920, Bitmap.Config.ARGB_8888)
//}