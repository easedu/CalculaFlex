package com.example.meunome.calculaflex.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)