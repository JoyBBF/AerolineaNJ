package com.example.aerolineanj.ui.home.reservation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.aerolineanj.ClickListener
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.Seat
import kotlinx.android.synthetic.main.item_seat.view.*
import kotlin.coroutines.coroutineContext


class SeatAdapter(val list: ArrayList<Seat>, var clickListener: ClickListener): RecyclerView.Adapter<SeatAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.item_seat, parent, false)

        var viewHolder = ViewHolder(vista, clickListener)

        return viewHolder!!
    }


    class ViewHolder(val view: View, listener: ClickListener): RecyclerView.ViewHolder(view), View.OnClickListener{

        var listener:ClickListener?= null

        init {
            this.listener = listener
        }

        fun render(seat: Seat){
            if(!seat.available){
                view.seatBtn.setColorFilter(ContextCompat.getColor(view.context, R.color.seatRed))
            }
            view.seatBtn.setOnClickListener(this)
            view.seatText.text = "S"+seat.row.toString()+"-"+seat.column.toString()
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }
    }

}