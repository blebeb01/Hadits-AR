package com.naufalm.haditsar.ui.screens.scan_hadits

import androidx.compose.runtime.Composable

@Composable
fun ARScreen() {

//    val nodes = remember { mutableListOf<ArNode>() }
//    val modelNode = remember { mutableStateOf<ArModelNode?>(null) }
//    val placeModelButton = remember { mutableStateOf(false) }
//    ARScene(
//        modifier = Modifier.fillMaxSize(),
//        nodes = nodes,
//        planeRenderer = true,
//        onCreate = {arSceneView ->
//            arSceneView.lightEstimationMode = Config.LightEstimationMode.DISABLED
//            arSceneView.planeRenderer.isShadowReceiver = false
//            modelNode.value = ArModelNode(arSceneView.engine, PlacementMode.INSTANT).apply {
//                loadModelGlbAsync(
//                    glbFileLocation = "models/burger.glb"
//                ) {
//
//                }
//                onAnchorChanged = { placeModelButton.value = !isAnchored}
//                onHitResult = {node, hitResult ->
//                    placeModelButton.value = node.isTracking
//                }
//                nodes.add(modelNode.value!!)
//            }
//        }
//    )
//    if (placeModelButton.value) {
//        Button(onClick = { modelNode.value?.anchor() }) {
//            Text(text = "Place it")
//        }
//    }
}