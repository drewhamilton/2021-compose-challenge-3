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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.ui.theme.grid
import com.example.androiddevchallenge.ui.theme.gridHalf

data class ExerciseCollection(
    val title: String,
    @DrawableRes val imageRes: Int,
)

@Composable fun ExerciseCollectionGroup(exerciseCollections: List<ExerciseCollection>) = LazyRow {
    val columnCount = exerciseCollections.size / 2
    items(columnCount) { columnIndex ->
        fun Modifier.columnPadding() = when (columnIndex) {
            0 -> padding(start = grid(2))
            columnCount - 1 -> padding(start = grid(1), end = grid(2))
            else -> padding(start = grid(1))
        }

        Column(
            modifier = Modifier.columnPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val topExerciseCollection = exerciseCollections[columnIndex * 2]
            ExerciseCollectionView(topExerciseCollection)

            val bottomExerciseCollectionIndex = columnIndex * 2 + 1
            if (bottomExerciseCollectionIndex < exerciseCollections.size) {
                Spacer(modifier = Modifier.height(grid(1)))
                val bottomExerciseCollection = exerciseCollections[bottomExerciseCollectionIndex]
                ExerciseCollectionView(bottomExerciseCollection)
            }
        }
    }
}

@Composable private fun ExerciseCollectionView(exerciseCollection: ExerciseCollection) = Surface(
    modifier = Modifier.width(grid(24)).clip(MaterialTheme.shapes.small)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = exerciseCollection.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(grid(7))
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = exerciseCollection.title,
            modifier = Modifier.padding(start = grid(2), end = gridHalf),
            style = MaterialTheme.typography.h3,
        )
    }
}
