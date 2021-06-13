package com.example.aerolineanj.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aerolineanj.ClickListener
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.Flight
import kotlinx.android.synthetic.main.item_flight.view.*


class FlightAdapter(val list: ArrayList<Flight>, var clickListener: ClickListener): RecyclerView.Adapter<FlightAdapter.ViewHolder>() {
    /*
    var listAplications: ArrayList<Flight>? = null
    var auxList: ArrayList<Flight>? = null
    private var recyclerViewClickInterface: ClickListener? = null
    var viewHolder:ViewHolder? = null

    init {
        this.recyclerViewClickInterface = clickListener
        this.listAplications = list
        this.auxList = list
    }
    */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*
        holder.tvDestination!!.setText(
            listAplications!!.get(position).schedule.route.destination
        )
        holder.tvDepartureDate!!.setText(listAplications!!.get(position).departureDate.toString())
        if(listAplications!!.get(position).returnDate != null){
            holder.tvReturnDate!!.setText(listAplications!!.get(position).returnDate.toString())
        }
        else{
            holder.tvReturnDate!!.setText("X")
        }
        holder.tvDuration!!.setText(listAplications!!.get(position).schedule.route.duration.toString())
        holder.tvPrice!!.setText(listAplications!!.get(position).schedule.price.toString())
        holder.tvDepartureTime!!.setText(listAplications!!.get(position).schedule.time.toString())
        */
        holder.render(list[position])
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.item_flight, parent, false)

        var viewHolder = ViewHolder(vista, clickListener)

        return viewHolder!!
    }


    class ViewHolder(val view: View, listener: ClickListener): RecyclerView.ViewHolder(view), View.OnClickListener{
        /*
        var tvDestination: TextView? = null
        var tvPrice: TextView? = null
        var tvDuration: TextView? = null
        var tvDepartureTime: TextView? = null
        var tvDepartureDate: TextView? = null
        var tvReturnDate: TextView? = null
        */
        var listener:ClickListener?= null

        init {
            /*
            tvDestination = view.destination
            tvPrice = view.price
            tvDuration = view.duration
            tvDepartureTime = view.departureTime
            tvDepartureDate = view.departureDate
            tvReturnDate = view.returnDate

            */
            this.listener = listener
        }

        fun render(flight: Flight){
            view.destination.text = flight.schedule.route.destination
            view.price.text = flight.schedule.price.toString()
            view.duration.text = flight.schedule.route.duration.toString()
            view.departureTime.text = flight.schedule.time.toString()
            view.departureDate.text = flight.departureDate.toString()
            if(flight.returnDate != null){
                view.returnDate.text = flight.returnDate.toString()
            }
            else{
                view.returnDate.text = "X"
            }

            view.setOnClickListener(this)
            }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }
    }

    /*
    fun filter(list: ArrayList<Flight>?) {
        if (list != null) listAplications = list else listAplications = auxList
        notifyDataSetChanged()
    }
    */

}