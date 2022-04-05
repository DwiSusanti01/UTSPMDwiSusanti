package com.dwisusanti.utspmdwisusanti.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//Tambahkan val parameter bilangan bulat stringResourceId ke konstruktor class Affirmation, untuk menghapus error
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
