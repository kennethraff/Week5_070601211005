package com.uc.moviecatalog.retrofit

import com.uc.moviecatalog.helper.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent:: class)
object AppModule {

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit):
            EndPointApi{
        return retrofit.create(EndPointApi::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitUnstance():Retrofit{
        return Retrofit.Builder().baseUrl(Const.BASE_URL_LOCALHOST).addConverterFactory(GsonConverterFactory.create()).build()
    }
}