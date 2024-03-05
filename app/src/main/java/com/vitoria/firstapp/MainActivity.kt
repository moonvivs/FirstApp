package com.vitoria.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vitoria.firstapp.databinding.ActivityMainBinding
import com.vitoria.firstapp.databinding.TelaLinearBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private  val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
            var email = binding.edtEmail2.editableText.toString()

            if(email.contains("@") && email.contains(".com")){
                binding.tvEmail.text = "Email: ${email}"
            }else{
                binding.tvEmail.text = "Email Inválido"
            }

            var telefone = binding.edtTelefone2.editableText.toString()
            val qtndNumero = telefone.length

            if (qtndNumero == 11){
                binding.tvTelefone.text = "Telefone: ${telefone}"
            }else{
                binding.tvTelefone.text = "Telefone Inválido "
            }
        }
    }
}
//            var nome = binding.edtName.editableText.toString()
//
//            binding.tvName.text = "Nome: " + nome
//
//            var anoNascimento = binding.edtAnoNascimento.editableText.toString()
//            var anoAtual = LocalDateTime.now().year
//            var idade = anoAtual - anoNascimento.toInt()
//
//            binding.tvIdade.text = "Idade: ${idade}"