package com.example.sprawdziancompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

data class ActivityItem(val icon: Int, val title: String, val count: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitStatisticsScreen(
                name = "Eduard Muntianov",
                activities = listOf(
                    ActivityItem(R.drawable.baseline_commit_24, "Committed changes", 22),
                    ActivityItem(R.drawable.baseline_comment_24, "Comment count", 15),
                    ActivityItem(R.drawable.baseline_merge_24, "Merged pull requests", 8),
                    ActivityItem(R.drawable.baseline_close_24, "Closed pull requests", 3),
                )
            ) {
                Toast.makeText(this, "Well done!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun GitStatisticsScreen(
    name: String,
    activities: List<ActivityItem>,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.man_person_icon),
                contentDescription = "User Icon",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "Git statistics", color = Color.Gray)
            }
        }


        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        Spacer(modifier = Modifier.height(24.dp))


        Text(text = "Recent Activities", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items( items = activities) { activity ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Gray, shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = activity.icon),
                        contentDescription = activity.title,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = activity.title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = activity.count.toString(),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        }


        Spacer(modifier = Modifier.weight(1f))


        HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))


        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A1B9A))
        ) {
            Text(text = "Display message", color = Color.White)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewGitStatisticsScreen() {
    GitStatisticsScreen(
        name = "Eduard Muntianov",
        activities = listOf(
            ActivityItem(R.drawable.baseline_commit_24, "Committed changes", 22),
            ActivityItem(R.drawable.baseline_comment_24, "Comment count", 15),
            ActivityItem(R.drawable.baseline_merge_24, "Merged pull requests", 8),
            ActivityItem(R.drawable.baseline_close_24, "Closed pull requests", 3),
        )
    ) {}
}