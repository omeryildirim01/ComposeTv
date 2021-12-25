package com.yildirimomer.composetv.ui.common

import com.yildirimomer.composetv.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object NowPlaying : NavigationItem("Now Playing", R.drawable.ic_baseline_airplay, "NowPlaying")
    object Popular : NavigationItem("Popular", R.drawable.ic_baseline_trending_up, "Popular")
    object Upcoming : NavigationItem("Upcoming", R.drawable.ic_baseline_watch_later, "Upcoming")
}
