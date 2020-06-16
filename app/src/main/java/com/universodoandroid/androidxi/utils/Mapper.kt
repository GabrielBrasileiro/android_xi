package com.universodoandroid.androidxi.utils

interface Mapper<I, O> {
    fun map(enter: I): O
}