package jp.shirataki707.cources.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val courseCount: Int,
    @DrawableRes val icon: Int
)
