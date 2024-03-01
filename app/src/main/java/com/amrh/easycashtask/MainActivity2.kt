package com.amrh.easycashtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.easycashtask.ui.theme.EasycashtaskTheme
import com.google.android.material.progressindicator.CircularProgressIndicator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity2 : ComponentActivity() {

    val viewModel: CompetitionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasycashtaskTheme {
              //  val isLoading by viewModel.loading
                LaunchedEffect(key1 = true) {
                    viewModel.getCompetitions()
                    observers()
                }
                MainScreen()
            }
        }
    }


    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                ProgressIndicator(true)
                ListPage()
            }
    }

    fun observers() {

        viewModel.compLD.observe(this) {
            it?.let {
                competitionsGl.value = it
            }
        }

    }

    val competitionsGl = MutableLiveData<List<CompetitionsItem>>(emptyList())
    @Composable
    fun ListPage() {

        val competitionsState = remember { mutableStateOf<List<CompetitionsItem>>(emptyList()) }

        competitionsGl.observe(this){
            competitionsState.value = it
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = competitionsState.value,
                key = { it.id }
            ) { image ->
                CompetitionItem(image)
            }

        }
    }
}


//@AndroidEntryPoint
//class MainActivity2 : ComponentActivity() {
//
//    val viewModel: CompetitionViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            EasycashtaskTheme {
//                ProgressIndicator(true)
//                ListPage()
//            }
//        }
//
//    }
//}
//
//
@Composable
fun ProgressIndicator(isLoading: Boolean) {
    // Remember the last indicator state
    val indicatorShown = remember { mutableStateOf(false) }

    // Update the indicator state if loading state changes
    if (isLoading != indicatorShown.value) {
        indicatorShown.value = isLoading
    }

    if (isLoading) {
        LinearProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
//
//
//@Composable
//fun ListPage() {
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentPadding = PaddingValues(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        items(
//            items = fakeCompetitionsList(),
//            key = {
//                it.id
//            }
//        ) { image ->
//            CompetitionItem(image)
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    EasycashtaskTheme {
//        ListPage()
//    }
//}
//
//
//fun fakeCompetitionsList(): List<CompetitionsItem> {
//    return listOf(
//        CompetitionsItem(
//            id = 2013,
//            area = Area(
//                id = 2032,
//                name = "Brazil",
//                code = "BRA",
//                flag = "https://crests.football-data.org/764.svg"
//            ),
//            name = "Campeonato Brasileiro Série A",
//            code = "BSA",
//            type = "LEAGUE",
//            emblem = "https://crests.football-data.org/764.svg",
//            plan = "TIER_ONE",
//            currentSeason = CurrentSeason(
//                id = 1557,
//                startDate = "2023-04-15",
//                endDate = "2023-12-03",
//                currentMatchday = 37,
//                winner = null
//            ),
//            numberOfAvailableSeasons = 7,
//            lastUpdated = "2021-07-20T18:42:17Z"
//        ),
//        CompetitionsItem(
//            id = 2016,
//            area = Area(
//                id = 2072,
//                name = "England",
//                code = "ENG",
//                flag = "https://crests.football-data.org/770.svg"
//            ),
//            name = "Championship",
//            code = "ELC",
//            type = "LEAGUE",
//            emblem = "https://crests.football-data.org/ELC.png",
//            plan = "TIER_ONE",
//            currentSeason = CurrentSeason(
//                id = 1573,
//                startDate = "2023-08-04",
//                endDate = "2024-05-04",
//                currentMatchday = 35,
//                winner = null
//            ),
//            numberOfAvailableSeasons = 7,
//            lastUpdated = "2022-03-20T09:31:30Z"
//        ),
//        CompetitionsItem(
//            id = 2017,
//            area = Area(
//                id = 2072,
//                name = "England",
//                code = "ENG",
//                flag = "https://crests.football-data.org/770.svg"
//            ),
//            name = "Championship",
//            code = "ELC",
//            type = "LEAGUE",
//            emblem = "https://crests.football-data.org/ELC.png",
//            plan = "TIER_ONE",
//            currentSeason = CurrentSeason(
//                id = 1573,
//                startDate = "2023-08-04",
//                endDate = "2024-05-04",
//                currentMatchday = 35,
//                winner = null
//            ),
//            numberOfAvailableSeasons = 7,
//            lastUpdated = "2022-03-20T09:31:30Z"
//        )
//    )
//
//}