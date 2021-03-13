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
package com.example.androiddevchallenge.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.ui.theme.grid

data class AlignmentExercise(
    val title: String,
    @DrawableRes val imageRes: Int,
)

@Composable fun AlignmentExerciseRow(alignmentExercises: List<AlignmentExercise>) = LazyRow(
) {
    items(alignmentExercises.size) { index ->
        fun Modifier.itemPadding() = when (index) {
            0 -> padding(start = grid(2))
            alignmentExercises.lastIndex -> padding(start = grid(1), end = grid(2))
            else -> padding(start = grid(1))
        }

        val alignmentExercise = alignmentExercises[index]
        Column(
            modifier = Modifier.itemPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = alignmentExercise.imageRes),
                contentDescription = null,
                modifier = Modifier.size(grid(11)).clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = alignmentExercise.title,
                modifier = Modifier.paddingFromBaseline(top = grid(3)),
                style = MaterialTheme.typography.h3,
            )
        }
    }
}
