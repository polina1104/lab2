package com.example.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.CounterViewModel

class CounterFragment : Fragment() {

    private lateinit var viewModel: CounterViewModel
    private lateinit var countTextView: TextView
    private lateinit var changeValue: EditText
    private lateinit var increaseButton: Button
    private lateinit var decreaseButton: Button

    companion object {
        fun newInstance() = CounterFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_counter, container, false)
        countTextView = view.findViewById(R.id.counterValue)
        changeValue = view.findViewById(R.id.counterChangeValue)
        increaseButton = view.findViewById(R.id.incButton)
        decreaseButton = view.findViewById(R.id.decButton)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        increaseButton.setOnClickListener {
            viewModel.incrementCounter(changeValue.text.toString().toInt())
        }

        decreaseButton.setOnClickListener {
            viewModel.decrementCounter(changeValue.text.toString().toInt())
        }

        viewModel.counter.observe(viewLifecycleOwner) { count ->
            countTextView.text = count.toString()
        }
    }
}
