package org.fhmsyhdproject.premiere.core.di

import androidx.room.Room
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.fhmsyhdproject.premiere.core.data.MovieRepository
import org.fhmsyhdproject.premiere.core.data.source.local.LocalDataSource
import org.fhmsyhdproject.premiere.core.data.source.local.room.MovieDatabase
import org.fhmsyhdproject.premiere.core.data.source.remote.RemoteDataSource
import org.fhmsyhdproject.premiere.core.data.source.remote.network.ApiService
import org.fhmsyhdproject.premiere.core.domain.repository.IMovieRepository
import org.fhmsyhdproject.premiere.core.utils.AppExecutors
import org.fhmsyhdproject.premiere.core.utils.Constant.BASE_URL
import org.fhmsyhdproject.premiere.core.utils.Constant.DB_MOVIE
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MovieDatabase>().movieDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, DB_MOVIE
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "premiere-api.fhmsyhdproject.dev"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> { MovieRepository(get(), get(), get()) }
}