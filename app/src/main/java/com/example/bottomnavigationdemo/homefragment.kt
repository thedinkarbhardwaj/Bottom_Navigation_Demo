package com.example.bottomnavigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnavigationdemo.databinding.FragmentHomefragmentBinding

class homefragment : Fragment() {

    lateinit var viewModel: homeViewmodel
    lateinit var binding: FragmentHomefragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel= ViewModelProvider(this.requireActivity()).get(homeViewmodel::class.java)
        binding = FragmentHomefragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.init(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(this.requireContext(),"ondestroyview home",Toast.LENGTH_SHORT).show()
    }

}