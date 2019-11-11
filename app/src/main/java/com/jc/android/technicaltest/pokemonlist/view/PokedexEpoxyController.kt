package com.jc.android.technicaltest.pokemonlist.view

import com.airbnb.epoxy.TypedEpoxyController
import com.jc.android.technicaltest.model.Pokemon

class PokedexEpoxyController : TypedEpoxyController<List<Pokemon>>() {
    override fun buildModels(data: List<Pokemon>?) {

        data?.forEach {
            pokemon {
                id(it.id)
                name(it.name)
            }
        }
    }
}