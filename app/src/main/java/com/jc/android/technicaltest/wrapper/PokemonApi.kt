package com.jc.android.technicaltest.wrapper

import com.jc.android.technicaltest.model.Pokedex
import com.jc.android.technicaltest.model.PokemonDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApi {

    /**
     * API endpoint for get Pokémon list as per the offered offset and limit.
     */
    @GET("pokemon")
    fun getPokedexRx(@Query("offset") offset: Int, @Query("limit") limit: Int): Single<Pokedex>

    /**
     * API endpoint for get specific Pokémpon detail as per the offered id.
     * @param pokemonId refers to the Pokémon id in Pokedex
     */
    @GET("pokemon/{pokemonId}/")
    fun getPokemonDetailRx(@Path("pokemonId") pokemonId: String): Single<PokemonDetails>
}