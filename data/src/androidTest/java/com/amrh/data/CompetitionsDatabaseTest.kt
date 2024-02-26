package com.amrh.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import app.cash.turbine.test
import com.amrh.data.competitions.local.db.CompetitionsDao
import com.amrh.data.competitions.local.db.CompetitionsDatabase
import com.amrh.data.competitions.pojo.FakeCompResource
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class CompetitionsDatabaseTest {

    private lateinit var favDao: CompetitionsDao
    private lateinit var database: CompetitionsDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        database = Room.inMemoryDatabaseBuilder(context, CompetitionsDatabase::class.java)
            .allowMainThreadQueries().build()
        favDao = database.CompetitionsDao()
    }

    @After
    fun tearDown() {
        database.close()
    }


    @Test
    fun insertCompetition() = runBlocking {
        val fakeComp = FakeCompResource(9871)
        favDao.insertCompetition(fakeComp)

        //actual
        val actual = favDao.selectCompetitions(fakeComp.id.toString())

        actual.test {
            assertSame(fakeComp, awaitItem())
        }
    }

    @Test
    fun selectAllIdsOnlyFromDataBase() = runBlocking {
        val fakeComp = FakeCompResource(20)
        val fakeComp2 = FakeCompResource(21)

        favDao.insertCompetition(fakeComp)
        favDao.insertCompetition(fakeComp2)

        //actual
        val actual = favDao.selectCompetitionsIDs()
        val expected = listOf(20, 21)

        actual.test {
            val awaitItem = awaitItem()

            assertEquals(expected[1], awaitItem[1])
            assertEquals(expected[0], awaitItem[0])

        }
    }

    @Test
    fun delete_comp_item() = runBlocking {
        val fakeitem = FakeCompResource(888)
        favDao.insertCompetition(fakeitem)
        favDao.deleteCompetition(fakeitem)

        val actualItem = favDao.selectCompetitions(fakeitem.id.toString())
        actualItem.test {

            assertEquals(null, awaitItem())

            // assertThat(allList).doesNotContain(actualItem)
        }


    }
}

