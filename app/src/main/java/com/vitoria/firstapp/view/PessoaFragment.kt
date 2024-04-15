package com.vitoria.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vitoria.firstapp.databinding.FragmentPessoaBinding
import com.vitoria.firstapp.service.model.Pessoa
import com.vitoria.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private  val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentPessoaBinding? = null
    private  val binding: FragmentPessoaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            val nome = binding.edtName.editableText.toString()
            val anoNascimento = binding.edtAnoNascimento.editableText.toString()
            val sexo = binding.edtSexo.editableText.toString()
            var faixaEtaria = ""


            if(nome != "" && anoNascimento != ""){


                val anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()


                if (idade < 12){
                    faixaEtaria = "Criança"
                }else if(idade < 18){
                    faixaEtaria = "Adolescente"
                }else if(idade < 65){
                    faixaEtaria = "Adulto"
                }else{
                    faixaEtaria = "Idoso"
                }


                val pessoa = Pessoa (
                    nome = nome,
                    idade = idade,
                    sexo = sexo,
                    faixaEtaria = faixaEtaria
                )

                viewModel.insert(pessoa)

                binding.edtName.editableText.clear()
                binding.edtAnoNascimento.editableText.clear()
                findNavController().navigateUp()

            }else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }
        }
    }
}