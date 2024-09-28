package jp.shirataki707.cources

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.shirataki707.cources.data.Topic
import jp.shirataki707.cources.ui.theme.CourcesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourcesTheme {

            }
        }
    }
}

@Composable
fun Topic(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = topic.icon),
                contentDescription = stringResource(id = topic.title),
                modifier = Modifier.size(68.dp)
            )
            Column {
                Text(
                    text = stringResource(id = topic.title),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
                )
                CourseCount(
                    courseCount = topic.courseCount,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun CourseCount(
    courseCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_grain),
            contentDescription = null,
        )
        Text(
            text = courseCount.toString(),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun CourseCountPreview() {
    CourseCount(courseCount = 321)
}

@Preview
@Composable
fun TopicPreview() {
    Topic(
        topic = Topic(R.string.architecture, 58, R.drawable.architecture)
    )
}
