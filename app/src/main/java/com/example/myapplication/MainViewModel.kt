package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Model.NewsItem

class MainViewModel {
    val lifeDataCurrent = MutableLiveData<NewsItem>()
}