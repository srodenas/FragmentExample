package com.santi.pmdm.virgen.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.santi.pmdm.virgen.fragmentexample.databinding.ActivityMainBinding
import com.santi.pmdm.virgen.fragmentexample.databinding.FragmentBlank1Binding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {


    private lateinit var binding :ActivityMainBinding
    private  var fragmentManager = supportFragmentManager
    private lateinit var fragment1: BlankFragment1
    private lateinit var fragment2: BlankFragment2
    private var stateInstance : Bundle? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("info", "Se crea el Activity")
        super.onCreate(savedInstanceState)
        stateInstance = savedInstanceState
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //if (savedInstanceState == null) {
        initDefaultFragment3()
        initListener()
        println("Entra en onCreate activity")
        //}
    }

    private fun initDefaultFragment() {
        fragment1 = BlankFragment1.newInstance("santi", "srodher115@g.educaand.es")
        fragment2 = BlankFragment2.newInstance("sonia", "smenadel@g.educaand.es")
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.fcw_2, fragment1)
        fragmentTransaction.commit()
    }

    private fun initDefaultFragment2(){
        fragment2 = BlankFragment2.newInstance("sonia", "smenadel@g.educaand.es")

        val bundle = Bundle()
        bundle.putString("NAME", "santi")
        bundle.putString("EMAIL", "srodher@g.educaand.es")

        fragment1 = BlankFragment1()
        fragment1.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.fcw_2, fragment1).commit()




    }

    /*

     */
    private fun initDefaultFragment3(){
        fragment2 = BlankFragment2.newInstance("sonia", "smenadel@g.educaand.es")

        /* val bundle = Bundle().apply {
             putString("ARG_NAME", "santi")
             putString("ARG_EMAIL", "srodher@g.educaand.es")
         }

         */
        val bundle = bundleOf(
            "NAME" to "santi",
            "EMAIL" to "srodher115@g.educaand.es"
        )
        fragment1 = BlankFragment1()
        fragment1.arguments = bundle


        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fcw_2, fragment1)
        }

          /*  supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<BlankFragment1>(R.id.fcw_2, args = bundle)
            }
        */
    }

    private fun initListener() {
        val btn1 = binding.btnSw1.setOnClickListener{
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fcw_2, fragment1)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        val btn2 = binding.btnSw2.setOnClickListener(){
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fcw_2, fragment2)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}

