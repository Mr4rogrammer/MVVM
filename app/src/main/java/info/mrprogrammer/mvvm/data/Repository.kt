package info.mrprogrammer.mvvm.data

import info.mrprogrammer.mvvm.domain.model.ResultModel
import info.mrprogrammer.mvvm.domain.interfaces.RepositoryInterface
import javax.inject.Inject

class Repository @Inject constructor(private val service: Service): RepositoryInterface {
    override suspend fun fetchData(): List<ResultModel> {
        return service.getDataFromApi()
    }
}