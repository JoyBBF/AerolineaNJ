package com.example.aerolineanj.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aerolineanj.ClickListener
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.Reservation
import com.example.aerolineanj.data.model.Seat
import kotlinx.android.synthetic.main.item_history.view.*

class HistoryAdapter(val list: ArrayList<Reservation>, var clickListener: ClickListener): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

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

        fun render(reservation: Reservation){
            view.destination3.text = reservation.flight.schedule.route.destination
            view.departureDate3.text = reservation.flight.departureDate.toString()
            view.returnDate3.text = reservation.flight.returnDate.toString()
            view.duration3.text = reservation.flight.schedule.route.duration.toString()
            view.departureTime3.text = reservation.flight.schedule.time.toString()
            view.seatsAmount3.text = reservation.tickets.size.toString()
            view.price3.text = (reservation.tickets.size * reservation.flight.schedule.price).toString()
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }
    }

}