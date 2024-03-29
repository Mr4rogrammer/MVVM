package info.mrprogrammer.mvvm.data

import info.mrprogrammer.mvvm.data.model.ResultModel
import info.mrprogrammer.mvvm.domain.UseCase
import info.mrprogrammer.mvvm.framework.FrameWork
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class UseCaseImp @Inject constructor(private val service: Service, private val frameWork: FrameWork):UseCase {
    override fun fetchData(): List<ResultModel> {
        return runBlocking { service.getDataFromApi() }
    }

    override fun isInterNetConnected(): Boolean {
        return frameWork.isInterNetConnected()
    }
}