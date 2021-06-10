package com.example.aerolineanj.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.User
import com.example.aerolineanj.databinding.FragmentHomeBinding
import java.sql.Date

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var usuarios : List<User> = listOf(
            User("Loria666", "Carlos", "Loria", "123", "CarlosLoria666@gmail.com",  Date.valueOf("03-02-1970"), 0, 22686666, 88888666, "100m norte de mas x menos Heredia", 0),
            User("NicoNicoNii", "Nicolas", "Maduro", "123", "NicoNicoNii@gmail.com", Date.valueOf("24-09-1986"), 0, 22680876, 88667733, "Venezuela", 1)
        )

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        /*
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        */
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}