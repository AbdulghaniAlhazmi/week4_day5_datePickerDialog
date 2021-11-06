package com.example.datepicker

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.util.*


class DatePickerFragment : Fragment() {

    private lateinit var dateBtn : Button
    private lateinit var dateText : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_date_picker, container, false)

        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)

        dateBtn = view.findViewById(R.id.dateBtn)
        dateText = view.findViewById(R.id.dateText)

        dateBtn.setOnClickListener {
            val datePick = DatePickerDialog(requireContext(),
                { _, year, month, day -> dateText.setText(""+ day +"/" + (month+1) + "/" + year)}
                ,year,month,day)
            datePick.show()
        }

        return view
    }


}
