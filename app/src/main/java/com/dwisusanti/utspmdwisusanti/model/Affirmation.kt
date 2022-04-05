package com.dwisusanti.utspmdwisusanti.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
// Affirmation sebagai nama class dalam paket model
data class Affirmation(
    //menambahkan val parameter bilangan bulat stringResourceId ke konstruktor class Affirmation
    @StringRes val stringResourceId: Int,
    // menambahkan val parameter imageResourceId ke konstruktor class Affirmation
    @DrawableRes val imageResourceId: Int
)
