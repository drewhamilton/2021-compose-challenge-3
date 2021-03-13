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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.MySootheTextField
import com.example.androiddevchallenge.ui.theme.grid
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.systemBarsPadding

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) = Box(modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(),
    ) {
        item {
            MySootheTextField(
                label = "Search",
                iconRes = R.drawable.ic_search,
                modifier = Modifier.padding(top = grid(7))
            )

            SectionHeader("FAVORITE COLLECTIONS")
            Spacer(modifier = Modifier.height(grid(1)))
            CollectionRow()
            Spacer(modifier = Modifier.height(grid(1)))
            CollectionRow()

            SectionHeader("ALIGN YOUR BODY")
            Spacer(modifier = Modifier.height(grid(1)))
            AlignmentExerciseRow(bodyAlignmentExercises)

            SectionHeader("ALIGN YOUR MIND")
            Spacer(modifier = Modifier.height(grid(1)))
            AlignmentExerciseRow(mindAlignmentExercises)
        }
    }

    val bottomNavigationHeight = grid(7)
    BottomNavigation(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .navigationBarsPadding()
            .height(bottomNavigationHeight),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 8.dp,
    ) {
        BottomNavigationItem(
            iconRes = R.drawable.ic_spa,
            label = "HOME",
            selected = true
        )
        BottomNavigationItem(
            iconRes = R.drawable.ic_account_circle,
            label = "PROFILE",
            selected = false
        )
    }

    FloatingActionButton(
        onClick = {},
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .navigationBarsPadding()
            .padding(bottom = bottomNavigationHeight / 2),
        backgroundColor = MaterialTheme.colors.primary,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
        ),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_play_arrow),
            contentDescription = "Play"
        )
    }
}

@Composable
private fun SectionHeader(text: String) = Text(
    text = text,
    modifier = Modifier.paddingFromBaseline(top = grid(5)).padding(horizontal = grid(2)),
    style = MaterialTheme.typography.h2,
)

@Composable
private fun RowScope.BottomNavigationItem(
    @DrawableRes iconRes: Int,
    label: String,
    selected: Boolean,
) = BottomNavigationItem(
    selected = selected,
    onClick = {},
    icon = {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
    },
    label = {
        Text(
            text = label,
            style = MaterialTheme.typography.caption,
        )
    },
)

private val bodyAlignmentExercises = listOf(
    AlignmentExercise("Inversions", R.drawable.inversions),
    AlignmentExercise("Quick yoga", R.drawable.quick_yoga),
    AlignmentExercise("Stretching", R.drawable.stretching),
    AlignmentExercise("Tabata", R.drawable.tabata),
    AlignmentExercise("HIIT", R.drawable.hiit),
    AlignmentExercise("Pre-natal yoga", R.drawable.pre_natal_yoga),
)

private val mindAlignmentExercises = listOf(
    AlignmentExercise("Meditate", R.drawable.meditate),
    AlignmentExercise("With kids", R.drawable.with_kids),
    AlignmentExercise("Aromatherapy", R.drawable.aromatherapy),
    AlignmentExercise("On the go", R.drawable.on_the_go),
    AlignmentExercise("With pets", R.drawable.with_pets),
    AlignmentExercise("High stress", R.drawable.high_stress),
)
