package com.vitoria.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vitoria.firstapp.databinding.FragmentVerificarBinding


class VerificarFragment : Fragment() {

    private var _binding: FragmentVerificarBinding? = null
    private val binding: FragmentVerificarBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVerificarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            var email = binding.edtEmail2.editableText.toString()

            if (email.contains("@") && email.contains(".com")) {
                binding.tvEmail.text = "Email: ${email}"
            } else {
                binding.tvEmail.text = "Email Inválido"
            }

            var telefone = binding.edtTelefone2.editableText.toString()
            val qtndNumero = telefone.length

            if (qtndNumero == 11) {
                binding.tvTelefone.text = "Telefone: ${telefone}"
            } else {
                binding.tvTelefone.text = "Telefone Inválido "
            }
        }
    }
}