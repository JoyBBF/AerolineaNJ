package com.example.aerolineanj.ui.home.reservation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aerolineanj.ClickListener
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.Seat
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.item_flight.*
import kotlinx.android.synthetic.main.item_seat.view.*


class ReservationFragment : Fragment(), ClickListener{

    var seats : ArrayList<Seat>? = null
    var selectedSeats : ArrayList<Seat>? = null
    var cuantity : Int? = null
    var flight : JsonObject? = null

    private var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        seats = ArrayList()
        selectedSeats = ArrayList()
        for (i in 1..11){
            for(j in 1..9){
                if(j%2==0){
                    seats?.add(Seat(i,  j, true))
                }
                else{
                    seats?.add(Seat(i,  j, false))
                }

            }
        }
        flight = Gson().fromJson(arguments?.getString("flight"), JsonObject::class.java)
        cuantity = arguments?.getInt("cuantity")
        Toast.makeText(activity, cuantity.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation, container, false)
    }

    override fun onResume() {
        super.onResume()
        selectedSeats = ArrayList()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.findViewById<TextView>(R.id.reservationTitle)?.text = "SELECT "+cuantity+" SEATS"
    }

    fun initRecycler(){
        recyclerView = view?.findViewById(R.id.seats_recycler_view)
        //recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.layoutManager = GridLayoutManager(activity, 9)
        var seatAdapter = SeatAdapter(seats!!, this)
        recyclerView?.adapter = seatAdapter
    }

    override fun onClick(v: View, position: Int) {
        if(seats!![position].available){
            if(selectedSeats!!.contains(seats!![position])){
                v?.seatBtn?.setColorFilter(ContextCompat.getColor(v.context, R.color.black))
                selectedSeats!!.remove(seats!![position])
            }
            else{
                v?.seatBtn?.setColorFilter(ContextCompat.getColor(v.context, R.color.seatGreen))
                selectedSeats!!.add(seats!![position])
                if(selectedSeats!!.size == cuantity){
                    val bundle = bundleOf("flight" to Gson().toJson(flight))
                    bundle.putString("seats", Gson().toJson(selectedSeats))
                    bundle.putString("time", arguments?.getString("time"))
                    Navigation.findNavController(requireView())?.navigate(R.id.action_reservationFragment_to_confirmPucharseFragment, bundle)
                }
            }
        }
        Toast.makeText(activity, seats!![position].row.toString()+"-"+seats!![position].column.toString(), Toast.LENGTH_SHORT).show()
    }

}