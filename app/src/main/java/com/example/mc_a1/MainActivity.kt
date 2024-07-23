package com.example.mc_a1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import com.example.mc_a1.ui.theme.MC_A1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MC_A1Theme {
                Surface( color = Color.White , modifier = Modifier.fillMaxSize()) {

                    fun generateStopsList(n: Int): List<String> {
                        val stops = mutableListOf<String>()
                        for (i in 0..n) {
                            stops.add("Stop $i")
                        }
                        return stops
                    }
                    fun generateDistancesList(n: Int, initialDistance: Double, increment: Double): List<Double> {
                        return (0..n).map { initialDistance + (it) * increment }
                    }

                    val lazyStops: List<String> by lazy {
                        generateSequence(0) { it + 1 }
                            .take(50)
                            .map { "Stop $it" }
                            .toList()
                    }
                    val lazyDistances: List<Double> by lazy {
                        generateSequence(0.0) { it + 5.0 } // Start distance at 10.0 and increment by 5.0
                            .take(50)
                            .toList()
                    }

                    val n = 10
                    val initialDistance = 0.0
                    val increment = 5.0
                    val stopsList = generateStopsList(n)
                    val distancesList = generateDistancesList(n, initialDistance, increment)

                    JourneyApp(lazyStops , lazyDistances)
                }
            }
        }
    }
}

@Composable
fun JourneyApp(stops: List<String> , distances: List<Double>) {

    val currentStopIndex = remember { mutableStateOf(0) }
    val distanceUnitKm = remember { mutableStateOf(true) }

    val totalDistance = distances.sum()
    val distanceCovered = distances.take(currentStopIndex.value + 1).sum()
    val distanceLeft = totalDistance - distanceCovered
    val progress = (distanceCovered / totalDistance) * 100

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Current Stop:  ${stops[currentStopIndex.value]}")
        Text(text = "Total Distance:${TotalDistance(totalDistance = totalDistance, distanceUnitKm = distanceUnitKm.value)}")
        Text(text = "Distance Covered: ${getFormattedDistance(distanceCovered, distanceUnitKm.value)}")
        Text(text = "Distance Left: ${getFormattedDistance(distanceLeft, distanceUnitKm.value)}")

        LinearProgressIndicator(
            progress = (progress.toFloat()/ 100f),
            modifier = Modifier.fillMaxWidth(),
        )

        Button(onClick = { moveToNextStop(currentStopIndex, stops.size) }) {
            Text(text = "Next Stop")
        }

        Button(onClick = { switchUnit(distanceUnitKm) }) {
            Text(text = "Switch Unit")
        }

        StopList(stops = stops,distances , currentStopIndex.value)
    }
}

@Composable
fun StopList(stops: List<String>, distances: List<Double>, currentIndex: Int) {
    LazyColumn {
        items(stops.size) { index ->
            val stop = stops[index]
            val distance = distances[index]
            val textColor = if (index == currentIndex) {
                Color.Blue // Change to your desired highlight color
            } else {
                Color.Black // Change to your default text color
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Stop: $stop",
                    color = textColor
                )
                Text(
                    text = "Distance: ${getFormattedDistance(distance, true)}",
                    color = textColor
                )
            }
        }
    }
}

@Composable
fun TotalDistance(totalDistance: Double, distanceUnitKm: Boolean): String {
    return  if (distanceUnitKm) {
        String.format("%.2f km", totalDistance)
    } else {
        String.format("%.2f miles", totalDistance * 0.621371)
    }

}

@Composable
fun getFormattedDistance(distance: Double, isKm: Boolean): String {
    return if (isKm) {
        String.format("%.2f km", distance)
    } else {
        String.format("%.2f miles", distance * 0.621371)
    }
}

fun moveToNextStop(currentStopIndex: MutableState<Int>, totalStops: Int) {
    currentStopIndex.value++
    if (currentStopIndex.value >= totalStops) {
        currentStopIndex.value = 0
    }
}

fun switchUnit(isKm: MutableState<Boolean>) {
    isKm.value = !(isKm.value)
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MC_A1Theme {
//
//        fun generateStopsList(n: Int): List<String> {
//            val stops = mutableListOf<String>()
//            for (i in 1..n) {
//                stops.add("Stop $i")
//            }
//            return stops
//        }
//        fun generateDistancesList(n: Int, initialDistance: Double, increment: Double): List<Double> {
//            return (1..n).map { initialDistance + (it - 1) * increment }
//        }
//
//        val lazyStops: List<String> by lazy {
//            generateSequence(1) { it + 1 }
//                .take(10) // Change 10 to the desired size
//                .map { "Stop $it" }
//                .toList()
//        }
//        val lazyDistances: List<Double> by lazy {
//            generateSequence(10.0) { it + 5.0 } // Start distance at 10.0 and increment by 5.0
//                .take(10) // Change 10 to the desired size
//                .toList()
//        }
//
//        val n = 10 // Example size
//        val initialDistance = 10.0
//        val increment = 5.0
//        val stopsList = generateStopsList(n)
//        val distancesList = generateDistancesList(n, initialDistance, increment)
//        JourneyApp(stopsList , distancesList)
//
//    }
//}