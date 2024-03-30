package info.mrprogrammer.mvvm.data

import info.mrprogrammer.mvvm.data.model.ResultModel
import info.mrprogrammer.mvvm.domain.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val service: Service):Repository {
    override suspend fun fetchDataFromApi(): List<ResultModel> {
        return service.getDataFromApi()
    }
}