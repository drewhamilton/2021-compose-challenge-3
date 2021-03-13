/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.MySootheButton
import com.example.androiddevchallenge.ui.theme.grid
import com.example.androiddevchallenge.ui.theme.gridHalf
import dev.chrisbanes.accompanist.insets.systemBarsPadding

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) = Box(modifier) {
    Image(
        painterResource(R.drawable.login),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "LOG IN",
            modifier = Modifier.paddingFromBaseline(bottom = grid(4)),
            style = MaterialTheme.typography.h1
        )

        LoginTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            label = "Email address",
        )
        Spacer(modifier = Modifier.height(grid(1)))
        LoginTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            label = "Password",
        )
        Spacer(modifier = Modifier.height(grid(1)))
        MySootheButton(
            text = "LOG IN",
            onClick = { /*TODO*/ },
        )

        val signUpText = "Sign up"
        val signUpMessage = "Don't have an account? $signUpText"
        val underlineStart = signUpMessage.indexOf(signUpText)
        val underlineEnd = underlineStart + signUpText.length
        Text(
            text = AnnotatedString(
                text = signUpMessage,
                spanStyles = listOf(
                    AnnotatedString.Range(
                        item = SpanStyle(textDecoration = TextDecoration.Underline),
                        start = underlineStart, end = underlineEnd
                    )
                )
            ),
            modifier = Modifier.paddingFromBaseline(top = 32.dp),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable private fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
) = TextField(
    value = value,
    onValueChange = onValueChange,
    modifier = Modifier
        .fillMaxWidth()
        .height(grid(7))
        .padding(horizontal = grid(2)),
    label = {
        Text(
            text = label,
            Modifier.padding(vertical = gridHalf, horizontal = grid(1)),
            style = MaterialTheme.typography.body1
        )
    },
    colors = TextFieldDefaults.textFieldColors(
        backgroundColor = MaterialTheme.colors.surface,
        focusedIndicatorColor = MaterialTheme.colors.onSurface,
        unfocusedIndicatorColor = MaterialTheme.colors.onSurface,
        focusedLabelColor = MaterialTheme.colors.onSurface,
        unfocusedLabelColor = MaterialTheme.colors.onSurface,
    )
)
