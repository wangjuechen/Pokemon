package com.jc.android.technicaltest.pokemonlist.repository

import com.jc.android.technicaltest.model.Pokedex
import com.jc.android.technicaltest.wrapper.PokemonApi
import io.reactivex.Single

private const val OFFSET = 20
private const val LIMIT = 20

class PokemonRepository(val api: PokemonApi) {
    fun getPokemonList(): Single<Pokedex> = api.getPokedexRx(OFFSET, LIMIT)
}