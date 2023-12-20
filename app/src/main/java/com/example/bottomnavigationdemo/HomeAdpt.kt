package com.example.bottomnavigationdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class HomeAdpt(var contex: homefragment, private val data: MutableList<dummyData>) : RecyclerView.Adapter<HomeAdpt.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.name
        holder.img.setImageResource(item.img)

        holder.textView.setOnClickListener{
            val navController =
                Navigation.findNavController(
                    contex.requireActivity(),
                    R.id.nav_host_fragment
                )

            navController.navigate(
                R.id.action_home_to_singleFragment
            )
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val img: ImageView = itemView.findViewById(R.id.img)
    }
}