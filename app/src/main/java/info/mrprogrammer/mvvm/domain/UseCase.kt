package info.mrprogrammer.mvvm.domain

import info.mrprogrammer.mvvm.data.model.ResultModel

interface UseCase{
    fun fetchData():List<ResultModel>
    fun isInterNetConnected():Boolean
}