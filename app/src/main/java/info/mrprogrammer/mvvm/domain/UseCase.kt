package info.mrprogrammer.mvvm.domain

import info.mrprogrammer.mvvm.data.model.ResultModel

interface UseCase{
    suspend fun fetchData():List<ResultModel>
    fun isInterNetConnected():Boolean
}