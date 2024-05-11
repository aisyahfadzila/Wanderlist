package org.d3if3044.wanderlist.navigation
import org.d3if3044.wanderlist.ui.screen.KEY_ID_Notes

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_Notes}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}