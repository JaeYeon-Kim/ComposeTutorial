package com.kjy.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}
data class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: Message) {
        // 텍스트 들에 대한 정렬 방법을 정의해야함
        // 내부 요소들을 수직으로 정렬
        // Row를 사용하면 항목을 수평으로 정렬할 수 있고 Box를 사용하면 요소를 쌓을 수 있음.
        // 메시지 레이아웃 주변에 Padding 옵션을 준다.
        Row(modifier = Modifier.padding(all = 8.dp)) {
            // 프로필 사진을 추가해 메시지 카드를 보완, ResourceManager를 사용하여 사진 라이브러리 에서 이미지를 가져오거나
            // 사용, 디자인 구조가 잘 구성된 Row 컴포저블을 추가하고 그 내부에 Image 컴포저블을 추가.
            /*
            또한 메시지 레이아웃의 구조를 보면 내부 요소의 간격이 균등하지 않고 이미지의 크기가 너무 큼.
            따라서 Modifier(수정자)로 크기, 레이아웃, 모양을 변경하거나 요소를 클릭가능하게 하는 기능 추가가 가능하다.
             */
            Image(
                painter = painterResource(R.drawable.animal_picture),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // 이미지 크기 40dp
                    .size(40.dp)
                    // 이미지의 모양을 원형으로 설정
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = msg.author)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.body)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(
            msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's a great!")
        )
    }
