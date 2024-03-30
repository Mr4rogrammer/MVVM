package info.mrprogrammer.mvvm.domain.interfaces

import info.mrprogrammer.mvvm.data.model.ResultModel

interface RepositoryInterface {
    suspend fun fetchData():List<ResultModel>
}