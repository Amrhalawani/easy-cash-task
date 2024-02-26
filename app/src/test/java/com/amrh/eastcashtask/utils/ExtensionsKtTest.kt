package com.amrh.eastcashtask.utils

import com.amrh.utils.formatDate
import com.amrh.utils.formatTimeHHMM
import org.junit.Assert.assertEquals
import org.junit.Test

class ExtensionsKtTest {

    @Test
    fun getDate() {
        val actual = formatDate("2024-03-01T14:00:00Z")

        val expected = "Fri, 1 Mar 2024"
        assertEquals(expected, actual)

    }

    @Test
    fun getTime() {

        val actual = formatTimeHHMM("2023-05-06T14:00:00Z")

        val expected = "14:00"
        assertEquals(expected, actual)
    }
}