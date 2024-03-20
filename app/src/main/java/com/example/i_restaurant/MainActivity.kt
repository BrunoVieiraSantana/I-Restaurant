package com.example.i_restaurant

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.i_restaurant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btEntradas.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btEntradas.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btEntradas.setTextColor(Color.WHITE)
                binding.btPrincipais.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPrincipais.setTextColor(Color.dark_gray)
                binding.btBebidas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btBebidas.setTextColor(Color.dark_gray)
                binding.btSobremesas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSobremesas.setTextColor(Color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Entradas"
                }
            }

        binding.btPrincipais.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btPrincipais.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btPrincipais.setTextColor(Color.WHITE)
                binding.btEntradas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btEntradas.setTextColor(Color.dark_gray)
                binding.btBebidas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btBebidas.setTextColor(Color.dark_gray)
                binding.btSobremesas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSobremesas.setTextColor(Color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Principais"
            }
        }

        binding.btBebidas.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btBebidas.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btBebidas.setTextColor(Color.WHITE)
                binding.btPrincipais.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPrincipais.setTextColor(Color.dark_gray)
                binding.btEntradas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btEntradas.setTextColor(Color.dark_gray)
                binding.btSobremesas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSobremesas.setTextColor(Color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Bebidas"
            }
        }

        binding.btSobremesas.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btSobremesas.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btSobremesas.setTextColor(Color.WHITE)
                binding.btBebidas.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btBebidas.setTextColor(Color.dark_gray)
                binding.btPrincipais.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btPrincipais.setTextColor(Color.dark_gray)
                binding.btEntradas.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btEntradas.setTextColor(Color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Sobremesas"
            }
        }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}