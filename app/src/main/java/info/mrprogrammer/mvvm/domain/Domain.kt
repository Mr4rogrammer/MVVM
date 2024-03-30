package info.mrprogrammer.mvvm.domain

import info.mrprogrammer.mvvm.data.RepositoryImp
import info.mrprogrammer.mvvm.data.model.ResultModel
import javax.inject.Inject

class Domain @Inject constructor(private val repositoryImp: RepositoryImp) {
    suspend fun fetchData():List<ResultModel> {
        return repositoryImp.fetchData()
    }
}