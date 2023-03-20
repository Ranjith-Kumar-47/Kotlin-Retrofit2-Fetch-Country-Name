package com.example.countrynames

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class CountryNameAdapter(
    private val countryNameModelClass: List<Data>,
    private val progressBar: ProgressBar,
    private val context: Context
) : RecyclerView.Adapter<CountryNameAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_name_card_design, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        progressBar.visibility = View.GONE
        holder.tvCountryName.text = countryNameModelClass[position].country
        holder.tvIso2.text = countryNameModelClass[position].iso2
        holder.tvIso3.text = countryNameModelClass[position].iso3
        val cities = countryNameModelClass[position].cities
        var check = true
        if (check) {
            holder.cardView.setOnClickListener {
                check = false
                holder.chipGroup.removeAllViews()
                holder.chipGroup.visibility = View.VISIBLE
                cities.forEach {
                    val chip = Chip(context)
                    chip.text = it.trim()
                    holder.chipGroup.addView(chip)
                }
            }
        } else if (!check) {
            holder.cardView.setOnClickListener {
                holder.chipGroup.visibility = View.GONE
            }

        }

//        Log.d("chip",cities[0])

    }

    override fun getItemCount(): Int {
        return countryNameModelClass.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCountryName: TextView = view.findViewById(R.id.tvCountryName)
        val tvIso2: TextView = view.findViewById(R.id.tvIso2)
        val tvIso3: TextView = view.findViewById(R.id.tvIso3)
        val chipGroup: ChipGroup = view.findViewById(R.id.chipGroup)
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
    }

}