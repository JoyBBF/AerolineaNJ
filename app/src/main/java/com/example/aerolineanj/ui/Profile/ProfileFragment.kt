package com.example.aerolineanj.ui.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.User
import com.example.aerolineanj.databinding.FragmentProfileBinding
import java.sql.Date

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var user = User("Mari", "Maria", "Solano", "123", "maria@gmail.com", Date.valueOf("1970-02-03"), 0, 111, 222, "abc", 0)
        view.findViewById<EditText>(R.id.textView11).setText(user.username)
        view.findViewById<EditText>(R.id.textView22).setText(user.name)
        view.findViewById<EditText>(R.id.textView33).setText(user.lastName)
        view.findViewById<EditText>(R.id.textView44).setText(user.email)
        view.findViewById<EditText>(R.id.textView55).setText(user.workPhone.toString())
        view.findViewById<EditText>(R.id.textView66).setText(user.cellPhone.toString())
        view.findViewById<EditText>(R.id.textView77).setText(user.direction)


        view.findViewById<Button>(R.id.SaveProfile).setOnClickListener{
            user.username = view.findViewById<EditText>(R.id.textView11).text.toString()
            user.name = view.findViewById<EditText>(R.id.textView22).text.toString()
            user.lastName = view.findViewById<EditText>(R.id.textView33).text.toString()
            user.email = view.findViewById<EditText>(R.id.textView44).text.toString()
            user.workPhone = view.findViewById<EditText>(R.id.textView55).text.toString().toInt()
            user.cellPhone = view.findViewById<EditText>(R.id.textView66).text.toString().toInt()
            user.direction = view.findViewById<EditText>(R.id.textView77).text.toString()

            Toast.makeText(activity, "USER UPDATED", Toast.LENGTH_SHORT).show()
        }
    }
}