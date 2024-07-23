//package com.example.mc_a1
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.mc_a1.ui.theme.MC_A1Theme
//import android.view.View
////import android.os.Bundle
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import android.widget.Button
//import android.widget.TextView
//import android.widget.ProgressBar
//import androidx.appcompat.app.AppCompatActivity
//
//class MainActivity : AppCompatActivity() {
//
//    // Normal list of stops and distances
//    private val normalStops = listOf("Stop 1", "Stop 2", "Stop 3", "Stop 4", "Stop 5", "Stop 6", "Stop 7", "Stop 8", "Stop 9", "Stop 10")
//    private val normalDistances = listOf(10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0, 45.0, 50.0, 55.0)
//
//    // Lazy list of stops and distances (15 stops)
//    private val lazyStops: List<String> by lazy {
//        listOf("Lazy Stop 1", "Lazy Stop 2", "Lazy Stop 3", "Lazy Stop 4", "Lazy Stop 5", "Lazy Stop 6", "Lazy Stop 7", "Lazy Stop 8", "Lazy Stop 9", "Lazy Stop 10", "Lazy Stop 11", "Lazy Stop 12", "Lazy Stop 13", "Lazy Stop 14", "Lazy Stop 15")
//    }
//
//    private val lazyDistances: List<Double> by lazy {
//        listOf(60.0, 65.0, 70.0, 75.0, 80.0, 85.0, 90.0, 95.0, 100.0, 105.0, 110.0, 115.0, 120.0, 125.0, 130.0)
//    }
//
//    private lateinit var currentStopTextView: TextView
//    private lateinit var distanceTextView: TextView
//    private lateinit var totalDistanceCoveredTextView: TextView
//    private lateinit var totalDistanceLeftTextView: TextView
//    private lateinit var nextStopButton: Button
//    private lateinit var switchUnitButton: Button
//    private lateinit var progressBar: ProgressBar
//
//    private var currentStopIndex = 0
//    private var distanceUnitKm = true
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        currentStopTextView = findViewById(R.id.currentStopTextView)
//        distanceTextView = findViewById(R.id.distanceTextView)
//        totalDistanceCoveredTextView = findViewById(R.id.totalDistanceCoveredTextView)
//        totalDistanceLeftTextView = findViewById(R.id.totalDistanceLeftTextView)
//        nextStopButton = findViewById(R.id.nextStopButton)
//        switchUnitButton = findViewById(R.id.switchUnitButton)
//        progressBar = findViewById(R.id.progressBar)
//
//        updateUI()
//
//        nextStopButton.setOnClickListener {
//            moveToNextStop()
//        }
//
//        switchUnitButton.setOnClickListener {
//            switchUnit()
//        }
////
//    }
//
//    private fun updateUI() {
//        currentStopTextView.text = normalStops[currentStopIndex]
//        distanceTextView.text = getFormattedDistance()
//
//        // Calculate total distance covered and left
//        val totalDistanceCovered = normalDistances.take(currentStopIndex + 1).sum()
//        val totalDistanceLeft = normalDistances.drop(currentStopIndex + 1).sum()
//
//        // Display total distance covered and left
//        totalDistanceCoveredTextView.text = getString(R.string.total_distance_covered, totalDistanceCovered)
//        totalDistanceLeftTextView.text = getString(R.string.total_distance_left, totalDistanceLeft)
//
//        // Update progress bar
//        val progress = ((currentStopIndex.toFloat() / normalStops.size.toFloat()) * 100).toInt()
//        progressBar.progress = progress
//    }
//
//    private fun getFormattedDistance(): String {
//        val distance = normalDistances[currentStopIndex]
//        return if (distanceUnitKm) {
//            getString(R.string.distance_km, distance)
//        } else {
//            val distanceMiles = distance * 0.621371
//            getString(R.string.distance_miles, distanceMiles)
//        }
//    }
//
//    private fun moveToNextStop() {
//        currentStopIndex++
//        if (currentStopIndex >= normalStops.size) {
//            currentStopIndex = 0
//        }
//        updateUI()
//    }
//
//    private fun switchUnit() {
//        distanceUnitKm = !distanceUnitKm
//        updateUI()
//    }
//    @Composable
//    private fun StopList(stops: List<String>) {
//        LazyColumn {
//            items(stops) { stop ->
//                Text(text = stop)
//            }
//        }
//    }
//}