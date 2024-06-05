package com.naufalm.haditsar.ui.screens.scan_hadits

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.ar.core.Config
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.ArNode
import io.github.sceneview.ar.node.PlacementMode

@Composable
fun ARScreen() {
    val nodes = remember { mutableListOf<ArNode>()}
    val modelNode = remember { mutableStateOf<ArModelNode?>(null) }
    val placeModelButton = remember { mutableStateOf(false) }
    ARScene(
        modifier = Modifier.fillMaxSize(),
        nodes = nodes,
        planeRenderer = true,
        onCreate = {arSceneView ->
            arSceneView.lightEstimationMode = Config.LightEstimationMode.DISABLED
            arSceneView.planeRenderer.isShadowReceiver = false
            modelNode.value = ArModelNode(arSceneView.engine, PlacementMode.INSTANT).apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/burger.glb"
                ) {

                }
                onAnchorChanged = { placeModelButton.value = !isAnchored}
                onHitResult = {node, hitResult ->
                    placeModelButton.value = node.isTracking
                }
                nodes.add(modelNode.value!!)
            }
        }
    )
    if (placeModelButton.value) {
        Button(onClick = { modelNode.value?.anchor() }) {
            Text(text = "Place it")
        }
    }
}