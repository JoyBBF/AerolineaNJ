package com.example.aerolineanj.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aerolineanj.ClickListener
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.*
import com.example.aerolineanj.databinding.FragmentHomeBinding
import com.google.gson.Gson
import java.sql.Date
import java.time.LocalTime

class HomeFragment : Fragment(), ClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var recyclerView : RecyclerView? = null
    var navController : NavController? = null

    //---------DATA---------
    var users : List<User> = listOf(
        User("Loria666", "Carlos", "Loria", "123", "CarlosLoria666@gmail.com",  Date.valueOf("1970-02-03"), 0, 22686666, 88888666, "100m norte de mas x menos Heredia", 0),
        User("NicoNicoNii", "Nicolas", "Maduro", "123", "NicoNicoNii@gmail.com", Date.valueOf("1986-09-24"), 0, 22680876, 88667733, "Venezuela", 1)
    )
    var routes : List<Route> = listOf(
        Route(1, "Costa Rica", "Japon", 20),
        Route(2, "Costa Rica", "Estados Unidos", 5),
        Route(3, "Costa Rica", "España", 12),
        Route(4, "Costa Rica", "Inglaterra", 13)
    )
    var planeTypes : List<PlaneType> = listOf(
        PlaneType(1, 6, 11),
        PlaneType(2, 9, 11)
    )
    var planes : List<Plane> = listOf(
        Plane(1, 1960, "747-400","Boeing",planeTypes[0]),
        Plane(2, 1995, "777-200","Boeing",planeTypes[0]),
        Plane(3, 1993, "A340-300","Airbus Industrie",planeTypes[1]),
        Plane(4, 2000, "767-300ER","Boeing",planeTypes[1]),
        Plane(5, 1992, "A330-300","Airbus Industrie",planeTypes[1]),
        Plane(6, 1983, "757-200 ","Boeing",planeTypes[0])
    )
    var schedules : List<Schedule> = listOf(
        Schedule(1, "Lunes", LocalTime.of(17,0), 650000, 5, planes[0], routes[0]),
        Schedule(2, "Martes", LocalTime.of(14,30), 200000, 0, planes[1], routes[1]),
        Schedule(3, "Miercoles", LocalTime.of(10,0), 500000, 3, planes[0], routes[2]),
        Schedule(4, "Jueves", LocalTime.of(6,0), 600000, 0, planes[3], routes[2]),
        Schedule(5, "Viernes", LocalTime.of(9,0), 685000, 0, planes[4], routes[3])
    )
    var flights : List<Flight> = listOf(
        Flight(1, Date.valueOf("2021-06-25"), null, schedules[0]),
        Flight(2, Date.valueOf("2021-06-02"), Date.valueOf("2021-06-07"), schedules[1]),
        Flight(3, Date.valueOf("2021-06-13"), Date.valueOf("2021-07-03"), schedules[2]),
        Flight(4, Date.valueOf("2021-05-28"), Date.valueOf("2021-06-10"), schedules[4]),
        Flight(5, Date.valueOf("2021-07-22"), Date.valueOf("2021-07-29"), schedules[3]),
        Flight(6, Date.valueOf("2021-06-25"), null, schedules[3]),
        Flight(7, Date.valueOf("2021-05-28"), Date.valueOf("2021-06-10"), schedules[4]),
        Flight(8, Date.valueOf("2021-07-22"), Date.valueOf("2021-07-29"), schedules[3]),
        Flight(9, Date.valueOf("2021-06-25"), null, schedules[3])
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        var numberPicker = view.findViewById(R.id.numberPicker) as NumberPicker
        numberPicker.minValue = 1
        numberPicker.maxValue = 10
        numberPicker.value = 1

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        view?.findViewById<Button>(R.id.searchButton)?.setOnClickListener {
            filterSearch()
        }
    }

    fun initRecycler(){
        recyclerView = view?.findViewById(R.id.flightsRecyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        var flightAdapter = FlightAdapter(ArrayList(flights), this)
        recyclerView?.adapter = flightAdapter
    }

    fun filterSearch(){
        var destination = view?.findViewById<EditText>(R.id.destinationTextField)?.text
        var auxList = ArrayList<Flight>()
        flights.filter { it.schedule.route.destination.contains(destination.toString()) }.forEach{auxList.add(it)}
        recyclerView?.adapter = FlightAdapter(ArrayList(auxList), this)
    }

    override fun onClick(vista: View, position: Int) {
        var parameter = Gson().toJson(flights[position]) as String
        val bundle = bundleOf("flight" to parameter)
        bundle.putInt("cuantity", view?.findViewById<NumberPicker>(R.id.numberPicker)!!.value)
        bundle.putString("time", flights[position].schedule.time.toString())
        navController?.navigate(R.id.action_nav_home_to_reservationFragment, bundle)
    }

}