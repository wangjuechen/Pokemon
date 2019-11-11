package com.jc.android.technicaltest.pokemonlist.view

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jc.android.technicaltest.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

@EpoxyModelClass(layout = R.layout.pokemon_list_item)
abstract class PokemonEpoxyModel : EpoxyModelWithHolder<PokemonEpoxyModel.Holder>() {

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var onClick: (String) -> Unit

    override fun bind(holder: Holder) {
        super.bind(holder)

        with(holder.itemView) {
            pokemonNameTextView.text = name

            setOnClickListener { onClick(id().toString()) }
        }
    }


    class Holder : EpoxyHolder(), LayoutContainer {
        lateinit var itemView: View
        override val containerView: View?
            get() = itemView

        override fun bindView(itemView: View) {
            this.itemView = itemView
        }
    }
}