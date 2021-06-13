package com.example.aerolineanj.ui.home.reservation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.aerolineanj.R
import com.example.aerolineanj.ui.home.HomeFragment

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
    }


}