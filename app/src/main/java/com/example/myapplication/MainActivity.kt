package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private var list = arrayListOf(
        "Análise e desenvolvimento de sistemas", "Gastronomia",
        "Direito", "Design Digital", "Engenharia Civil"
    )

    private var userList = arrayListOf(
        Usuario(
            nome = "Beatriz Fernandes",
            email = "email@email.com",
            matricula = "123456",
            cpf = "98765432100",
            genero = "FEM",
            dtNasc = "25/06/1997",
            curso = list[0],
            fotoUrl = "https://play-lh.googleusercontent.com/S70rI7VrwLic7_p-ax7iAOOopQhcPCzmqyLe5RLJmApTpkgTRaCwWsTNN1Uv1t_t3Pp5"
        ),
        Usuario(
            nome = "Beatriz Fernandes",
            email = "email@email.com",
            matricula = "123456",
            cpf = "98765432100",
            genero = "FEM",
            dtNasc = "25/06/1997",
            curso = list[1],
            fotoUrl = "https://play-lh.googleusercontent.com/S70rI7VrwLic7_p-ax7iAOOopQhcPCzmqyLe5RLJmApTpkgTRaCwWsTNN1Uv1t_t3Pp5"
        ),
        Usuario(
            nome = "Beatriz Fernandes",
            email = "email@email.com",
            matricula = "123456",
            cpf = "98765432100",
            genero = "FEM",
            dtNasc = "25/06/1997",
            curso = list[2],
            fotoUrl = "https://play-lh.googleusercontent.com/S70rI7VrwLic7_p-ax7iAOOopQhcPCzmqyLe5RLJmApTpkgTRaCwWsTNN1Uv1t_t3Pp5"
        ),
        Usuario(
            nome = "Beatriz Fernandes",
            email = "email@email.com",
            matricula = "123456",
            cpf = "98765432100",
            genero = "FEM",
            dtNasc = "25/06/1997",
            curso = list[3],
            fotoUrl = "https://play-lh.googleusercontent.com/S70rI7VrwLic7_p-ax7iAOOopQhcPCzmqyLe5RLJmApTpkgTRaCwWsTNN1Uv1t_t3Pp5"
        ),
        Usuario(
            nome = "Beatriz Fernandes",
            email = "email@email.com",
            matricula = "123456",
            cpf = "98765432100",
            genero = "FEM",
            dtNasc = "25/06/1997",
            curso = list[4],
            fotoUrl = "https://play-lh.googleusercontent.com/S70rI7VrwLic7_p-ax7iAOOopQhcPCzmqyLe5RLJmApTpkgTRaCwWsTNN1Uv1t_t3Pp5"
        ),
    )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListView(userList)
    }

    private fun setupListView(usuarios: ArrayList<Usuario>) {
        val adapter = MyAdapter()
        adapter.clickListener = {
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("USUARIO", it)

            startActivity(intent)

            val prefs = this.getSharedPreferences("", Context.MODE_PRIVATE)

            val usuarioString = Gson().toJson(it).toString()

            prefs.edit().putString("USUARIO", usuarioString).apply()
        }

        adapter.submitList(usuarios)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}