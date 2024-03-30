package info.mrprogrammer.mvvm.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import info.mrprogrammer.mvvm.data.Repository
import info.mrprogrammer.mvvm.data.Service
import info.mrprogrammer.mvvm.data.interfaces.ApiService
import info.mrprogrammer.mvvm.domain.Domain
import info.mrprogrammer.mvvm.framework.FrameWorkImp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getRetrofitClient(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.restful-api.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun getService(apiService: ApiService): Service {
        return Service(apiService)
    }

    @Provides
    @Singleton
    fun getFrameWork(@ApplicationContext applicationContext: Context): FrameWorkImp {
        return FrameWorkImp(applicationContext)
    }

    @Provides
    @Singleton
    fun getRepository(service: Service): Repository {
        return Repository(service)
    }

    @Provides
    @Singleton
    fun getDomain(repositoryImp: Repository):Domain {
        return Domain(repository = repositoryImp)
    }
}