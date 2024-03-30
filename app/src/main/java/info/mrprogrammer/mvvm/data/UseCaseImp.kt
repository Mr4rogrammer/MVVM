package info.mrprogrammer.mvvm.data

import info.mrprogrammer.mvvm.data.model.ResultModel
import info.mrprogrammer.mvvm.domain.UseCase
import info.mrprogrammer.mvvm.framework.FrameWork
import javax.inject.Inject

class UseCaseImp @Inject constructor(
    private val service: Service,
    private val frameWork: FrameWork
) : UseCase {
    override suspend fun fetchData(): List<ResultModel> {
        val result =  service.getDataFromApi()
        return result.subList(0, result.size / 2)
    }

    override fun isInterNetConnected(): Boolean {
        return frameWork.isInterNetConnected()
    }
}