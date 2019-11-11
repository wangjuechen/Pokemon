package com.jc.android.technicaltest.pokemonlist.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jc.android.technicaltest.model.Pokemon
import com.jc.android.technicaltest.pokemonlist.repository.PokemonRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

private const val REGEX_PATTERN = "https://pokeapi.co/api/v2/pokemon/?/"
private const val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"

class PokedexViewModel(
    val pokemonRepository: PokemonRepository
) : ViewModel() {

    var pokemonList = MutableLiveData<MutableList<Pokemon>?>()

    private val disposables = CompositeDisposable()

    init {
//        localPokedex()
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

    private fun localPokedex() {
        pokemonRepository.getPokemonList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    Log.d("Pokemon:", it.results.toString())
                    it.results.forEach { pokemon ->
                        pokemonList.value?.add(
                            Pokemon(
                                name = pokemon.name,
                                url = pokemon.url,
                                id = pokemon.url.retrieveId()
                            )
                        )
                    }
                },
                onError = {
                    Log.d("Pokemon:", it.message)
                }
            ).addTo(disposables)
    }


    private fun String.retrieveId(): String {
        val isValidFormat = this matches REGEX_PATTERN.toRegex()
        require(isValidFormat) { "Url format is invalid." }

        return this.replace(BASE_URL, "").removeSuffix("/")
    }
}