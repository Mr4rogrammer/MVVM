package info.mrprogrammer.mvvm.domain

import info.mrprogrammer.mvvm.data.Repository
import info.mrprogrammer.mvvm.data.model.ResultModel
import javax.inject.Inject

class Domain @Inject constructor(private val repository: Repository) {
    suspend fun fetchData():List<ResultModel> {
        return repository.fetchData()
    }
}