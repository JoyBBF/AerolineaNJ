package com.example.aerolineanj.ui.home.reservation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.aerolineanj.R
import com.example.aerolineanj.ui.home.HomeFragment
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.time.LocalTime

class ConfirmPurchaseFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_pucharse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.findViewById<Button>(R.id.confirmBtn)?.setOnClickListener {
            Toast.makeText(activity, "Purchase Completed", Toast.LENGTH_SHORT)
            Navigation.findNavController(view).navigate(R.id.action_confirmPucharseFragment_to_nav_home)
        }
        view?.findViewById<Button>(R.id.cancelBtn)?.setOnClickListener {
            Toast.makeText(activity, "Purchase Canceled", Toast.LENGTH_SHORT)
            Navigation.findNavController(view).navigate(R.id.action_confirmPucharseFragment_to_nav_home)
        }
        var flight = Gson().fromJson(arguments?.getString("flight"), JsonObject::class.java)
        var seats = Gson().fromJson(arguments?.getString("seats"), JsonArray::class.java)
        Toast.makeText(activity, seats.toString(), Toast.LENGTH_SHORT).show()

        view.findViewById<TextView>(R.id.destinationFld).text = flight.get("schedule").asJsonObject.get("route").asJsonObject.get("destination").asString
        view.findViewById<TextView>(R.id.cuantity).text = seats.size().toString()
        var str = "->["
        for(i in 1..seats.size()){
            str += "S" + seats[i-1].asJsonObject.get("row") + "-" + seats[i-1].asJsonObject.get("column")
            if(i < seats.size()){
                str += ", "
            }
        }
        str += "]"
        view.findViewById<TextView>(R.id.seats).text = str
        view.findViewById<TextView>(R.id.departureDate2).text = flight.get("departureDate").asString
        if(flight.get("returnDate") != null){
            view.findViewById<TextView>(R.id.returnDate2).text = flight.get("returnDate").toString()
        }else{
            view.findViewById<TextView>(R.id.returnDate2).text = "X"
        }
        view.findViewById<TextView>(R.id.duration2).text = flight.get("schedule").asJsonObject.get("route").asJsonObject.get("duration").asString
        view.findViewById<TextView>(R.id.time2).text = arguments?.getString("time")
        view.findViewById<TextView>(R.id.basePrice).text = flight.get("schedule").asJsonObject.get("price").asString
        view.findViewById<TextView>(R.id.price2).text = (flight.get("schedule").asJsonObject.get("price").asInt * seats.size()).toString()
    }


}