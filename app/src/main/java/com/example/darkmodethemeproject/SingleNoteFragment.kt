package com.example.darkmodethemeproject

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.darkmodethemeproject.databinding.FragmentSingleNoteBinding


class SingleNoteFragment : Fragment() {

    var NightMode = 0
    lateinit var sharedPreferences: SharedPreferences

    lateinit var editor: SharedPreferences.Editor

    lateinit var fragmentSingleNoteBinding: FragmentSingleNoteBinding
    private var nightMode = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentSingleNoteBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_single_note, container, false)

        sharedPreferences = requireContext().getSharedPreferences("SharedPrefs", MODE_PRIVATE)
        NightMode = sharedPreferences.getInt("NightModeInt", 1)
        AppCompatDelegate.setDefaultNightMode(NightMode)

        // Save switch state in shared preferences
        val sharedPreferences2: SharedPreferences = requireContext().getSharedPreferences("save", MODE_PRIVATE)
        fragmentSingleNoteBinding.switcher.isChecked = sharedPreferences2.getBoolean("value", true)

        handleMode()

        return fragmentSingleNoteBinding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        NightMode = AppCompatDelegate.getDefaultNightMode()

        sharedPreferences = requireContext().getSharedPreferences("SharedPrefs", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        editor.putInt("NightModeInt", NightMode)
        editor.apply()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun handleMode() {
        if (nightMode) {
            fragmentSingleNoteBinding.switcher.isChecked = true
        }
        
        fragmentSingleNoteBinding.switcher.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                val editor2: SharedPreferences.Editor =
                    requireContext().getSharedPreferences("save", MODE_PRIVATE).edit()
                editor2.putBoolean("value", true)
                editor2.apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                val editor2: SharedPreferences.Editor =
                    requireContext().getSharedPreferences("save", MODE_PRIVATE).edit()
                editor2.putBoolean("value", false)
                editor2.apply()
            }
        }

//        fragmentSingleNoteBinding.switcher.setOnClickListener {
//            if (fragmentSingleNoteBinding.switcher.isChecked) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                val editor2: SharedPreferences.Editor =
//                    requireContext().getSharedPreferences("save", MODE_PRIVATE).edit()
//                editor2.putBoolean("value", true)
//                editor2.apply()
//                fragmentSingleNoteBinding.switcher.isChecked = true
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                val editor2: SharedPreferences.Editor =
//                    requireContext().getSharedPreferences("save", MODE_PRIVATE).edit()
//                editor2.putBoolean("value", false)
//                editor2.apply()
//                fragmentSingleNoteBinding.switcher.isChecked = false
//            }
//        }
    }
}