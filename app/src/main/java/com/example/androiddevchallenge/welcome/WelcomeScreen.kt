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
package com.example.androiddevchallenge.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.MySootheButton
import com.example.androiddevchallenge.ui.theme.grid
import dev.chrisbanes.accompanist.insets.systemBarsPadding

@Composable
fun WelcomeScreen(
    onLogIn: () -> Unit,
    modifier: Modifier = Modifier
) = Box(modifier) {
    Image(
        painterResource(R.drawable.welcome),
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
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.width(grid(18)).wrapContentHeight()
        )
        Spacer(modifier = Modifier.height(grid(4)))
        MySootheButton(
            text = "SIGN UP",
            onClick = {},
            backgroundColor = MaterialTheme.colors.primary,
        )
        Spacer(modifier = Modifier.height(grid(1)))
        MySootheButton(
            text = "LOG IN",
            onClick = { onLogIn() },
            backgroundColor = MaterialTheme.colors.secondary,
        )
    }
}
