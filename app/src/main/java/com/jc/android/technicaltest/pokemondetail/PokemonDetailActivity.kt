package com.jc.android.technicaltest.pokemondetail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import com.jc.android.technicaltest.R
import com.jc.android.technicaltest.pokemonlist.PokedexActivity

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [PokedexActivity].
 */
class PokemonDetailActivity : AppCompatActivity(R.layout.activity_pokemon_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this, PokedexActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
