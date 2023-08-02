package com.santi.pmdm.virgen.fragmentexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.santi.pmdm.virgen.fragmentexample.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {
    private var name: String? = null
    private var email: String? = null
    lateinit var binding : FragmentBlank1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("info", "Se crea el fragment")
/*
        val bundle = arguments
        if (bundle != null) {
            name = bundle!!.getString("name")
            email = bundle!!.getString("email")
        }

 */
        //Si tengo argumentos, los recuperamos.

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank1Binding.inflate(inflater, container, false)

        arguments?.let {
            name = it.getString(ARG_NAME)
            email = it.getString(ARG_EMAIL)
            Log.i("info",name!!)
        }

        if (!email.isNullOrEmpty())
            binding.btnFragment1.setText(email)

        return binding.root
    }

    companion object {

        private const val ARG_NAME = "NAME"
        private const val ARG_EMAIL = "EMAIL"

        fun newInstance(param1: String, param2: String) =
            BlankFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, param1)
                    putString(ARG_EMAIL, param2)
                }
            }
    }
}