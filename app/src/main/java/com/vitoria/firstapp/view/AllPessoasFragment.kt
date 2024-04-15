package com.vitoria.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitoria.firstapp.R
import com.vitoria.firstapp.databinding.FragmentAllPessoasBinding
import com.vitoria.firstapp.view.adapter.PessoaAdpter
import com.vitoria.firstapp.viewmodel.AllPessoaViewModel

class AllPessoasFragment : Fragment() {

    // Chamar a ViewModel
    private  val viewModel: AllPessoaViewModel by viewModels()

    // Chamar o adapter
    private lateinit var adapter: PessoaAdpter

    // Criar o binding
    private var _binding: FragmentAllPessoasBinding? = null
    private  val binding: FragmentAllPessoasBinding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        // Configurar o binding
        _binding = FragmentAllPessoasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Quando clicar em algum item da lista
        adapter = PessoaAdpter(viewModel.pessoaList.value) {

        }

        // Configura a recycler
        val recycler = binding.rvPessoas
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // Observa para adicionar um item na lista quando for adicionado
        viewModel.pessoaList.observe(viewLifecycleOwner){
            adapter.updatePessoas(it)
        }

        // Navegar para a tela de cadastro de pessoa
        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.pessoaFragment)
        }

        // Carregar as pessoas cadastradas
        viewModel.loadPessoas()

    }
}