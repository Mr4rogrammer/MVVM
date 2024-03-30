package info.mrprogrammer.mvvm.domain

import info.mrprogrammer.mvvm.data.model.ResultModel

interface Repository {
    suspend fun fetchDataFromApi():List<ResultModel>
}