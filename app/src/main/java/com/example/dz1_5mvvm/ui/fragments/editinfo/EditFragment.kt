package com.example.dz1_5mvvm.ui.fragments.editinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dz1_5mvvm.R
import com.example.dz1_5mvvm.databinding.FragmentEditBinding

class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private val viewModel by viewModels<EditViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setupListener()
    }

    private fun getData() = with(binding) {
        viewModel.getInfo().observe(viewLifecycleOwner) {
            etName.setText(it.username)
            etAge.setText(it.age.toString())
            etMail.setText(it.email)
            etPassword.setText(it.password)
        }
    }

    private fun setupListener() = with(binding) {
        btmChange.setOnClickListener {
            if (etName.text.isEmpty()) {
                etName.error = "Заполните поле"
            } else if (etAge.text.isEmpty()) {
                etAge.error = "Заполните поле"
            } else if (etMail.text.isEmpty()) {
                etMail.error = "Заполните поле"
            } else if (etPassword.text.isEmpty()) {
                etPassword.error = "Заполните поле"
            } else {
                val name = etName.text.toString().trim()
                val age = etAge.text.toString().trim()
                val email = etMail.text.toString().trim()
                val password = etPassword.text.toString().trim()

                viewModel.updateUserInfo(name, age.toInt(), email, password)
                findNavController().navigateUp()
            }
        }
    }
}