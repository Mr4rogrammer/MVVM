package info.mrprogrammer.mvvm.data.interfaces

import info.mrprogrammer.mvvm.domain.model.ResultModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("objects")
    fun getObjects(): Call<List<ResultModel>>
}
