package com.jc.android.technicaltest.koin

import com.jc.android.technicaltest.pokemonlist.repository.PokemonRepository
import com.jc.android.technicaltest.pokemonlist.view.PokedexViewModel
import com.jc.android.technicaltest.wrapper.PokemonApi
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


val viewModelModule = module {
    viewModel {
        PokedexViewModel(get())
    }
}

val repositoryModule = module {
    fun provideUserRepository(api: PokemonApi): PokemonRepository {
        return PokemonRepository(api)
    }

    single {
        PokemonRepository(get())
    }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }

    single { provideUseApi(get()) }
}

val retrofitModule = module {

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .client(client)
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()
    }

    single { provideHttpClient() }
    single { provideRetrofit(get()) }
}