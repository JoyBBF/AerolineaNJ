package com.example.aerolineanj.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aerolineanj.ClickListener
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.Flight
import kotlinx.android.synthetic.main.item_flight.view.*


class FlightAdapter(list: ArrayList<Flight>, var clickListener: ClickListener): RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    var listAplications: ArrayList<Flight>? = null
    var auxList: ArrayList<Flight>? = null
    private var recyclerViewClickInterface: ClickListener? = null
    var viewHolder:ViewHolder? = null

    init {
        this.recyclerViewClickInterface = clickListener
        this.listAplications = list
        this.auxList = list
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvname!!.setText(
            listAplications!!.get(position).firstName.toString() + " " + listAplications!!.get(
                position
            ).lastName
        )
        holder.tvState!!.setText(listAplications!!.get(position).state)
        holder.tvStartDay!!.setText(listAplications!!.get(position).date)
        holder.tvPosition!!.setText(listAplications!!.get(position).position)
        holder.tvPhone!!.setText(
            "+" + listAplications!!.get(position).areaCode
                .toString() + " " + listAplications!!.get(position).phone
        )

    }

    override fun getItemCount(): Int {
        return listAplications!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.item_flight, parent, false)

        viewHolder = ViewHolder(vista, clickListener)

        return viewHolder!!
    }


    class ViewHolder(view: View, listener: ClickListener): RecyclerView.ViewHolder(view), View.OnClickListener{

        var tvDestination: TextView? = null
        var tvPrice: TextView? = null
        var tvDuration: TextView? = null
        var tvDeparture: TextView? = null

        var listener:ClickListener?= null

        init {
            tvDestination = view.destination
            tvPrice = view.price
            tvDuration = view.duration
            tvDeparture = view.departure

            this.listener = listener

            view.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
            this.listener?.onLongClick(v!!, adapterPosition)
        }


    }

    fun filter(list: ArrayList<Flight>?) {
        if (list != null) listAplications = list else listAplications = auxList
        notifyDataSetChanged()
    }


}