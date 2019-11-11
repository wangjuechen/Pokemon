package com.jc.android.technicaltest.pokemonlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.TypedEpoxyController
import com.jc.android.technicaltest.R
import com.jc.android.technicaltest.model.Pokemon
import com.jc.android.technicaltest.pokemonlist.view.PokedexEpoxyController
import com.jc.android.technicaltest.pokemonlist.view.PokedexViewModel
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Main activity representing a list of Pokémons from API.
 */
class PokedexActivity : AppCompatActivity(R.layout.activity_pokemon_list) {

    private lateinit var pokedexEpoxyController: TypedEpoxyController<List<Pokemon>>

    private val pokedexViewModel by viewModel<PokedexViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pokedexEpoxyController = PokedexEpoxyController()

        pokemonListRecyclerView.layoutManager = LinearLayoutManager(this)
        pokemonListRecyclerView.adapter = pokedexEpoxyController.adapter

        pokedexViewModel.pokemonList.observe(this, Observer {
            pokedexEpoxyController.setData(it)
        })
    }
}
