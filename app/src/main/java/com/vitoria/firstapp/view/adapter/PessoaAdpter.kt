package com.vitoria.firstapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitoria.firstapp.databinding.ListItemPessoaBinding
import com.vitoria.firstapp.service.model.Pessoa

class PessoaAdpter(pessoas: List<Pessoa>?, private val  clickListListener: (Pessoa) -> Unit):
    RecyclerView.Adapter<PessoaAdpter.PessoaViewHolder>(){

        private var pessoaList: List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private  val binding: ListItemPessoaBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit) {
                    binding.tvNome.text = pessoa.nome
                    binding.tvIdade.text = pessoa.idade.toString()
                    binding.tvFaixaEtaria.text = pessoa.faixaEtaria

                    if (pessoa.sexo == "masculino"){
                        binding.imgSexoM.visibility = View.VISIBLE
                        binding.imgSexoF.visibility = View.GONE
                    }else{
                        binding.imgSexoF.visibility = View.VISIBLE
                        binding.imgSexoM.visibility = View.GONE
                    }

                    binding.root.setOnClickListener{
                        clickListListener(pessoa)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return  PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }

    fun updatePessoas(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}