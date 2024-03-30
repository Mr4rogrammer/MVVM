package info.mrprogrammer.mvvm.data

import info.mrprogrammer.mvvm.data.interfaces.ApiService
import info.mrprogrammer.mvvm.data.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import javax.inject.Inject


class Service @Inject constructor(private val apiService: ApiService) {

    suspend fun getDataFromApi(): List<ResultModel> {
        return withContext(Dispatchers.IO) {
            val call: Call<List<ResultModel>> = apiService.getObjects()
            val response = call.execute()
            if (response.isSuccessful) {
                response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception("Unsuccessful response: ${response.code()}")
            }
        }
    }
}