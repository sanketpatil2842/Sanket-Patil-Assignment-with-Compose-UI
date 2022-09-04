package com.sanketpatil.di

import android.content.Context
import com.sanketpatil.common.Constant
import com.sanketpatil.data.repository.ProductRepositoryImp
import com.sanketpatil.data.source.remote.api.ProductApi
import com.sanketpatil.domain.dashboard.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkHTTPClient(@ApplicationContext context: Context): OkHttpClient {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)
        val builder = OkHttpClient.Builder().cache(myCache)
        return builder.build()
    }

    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofitClient(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .baseUrl(Constant.BASE_URL)
            .build()

    }

    @Provides
    fun providesRetrofitProductApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    @Provides
    fun provideProductRepository(productApi: ProductApi): ProductRepository {
        return ProductRepositoryImp(productApi)
    }
}