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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.ui.theme.grid
import com.example.androiddevchallenge.ui.theme.gridHalf

@Composable
fun MySootheTextField(
    label: String,
) = TextField(
    value = "",
    onValueChange = {},
    modifier = Modifier
        .fillMaxWidth()
        .height(grid(7))
        .padding(horizontal = grid(2)),
    placeholder = {
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
        placeholderColor = MaterialTheme.colors.onSurface,
    )
)
