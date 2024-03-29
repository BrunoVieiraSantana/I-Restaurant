package com.example.i_restaurant

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.i_restaurant.databinding.ActivityMainBinding
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.i_restaurant.adapter.ProductAdapter
import com.example.i_restaurant.listitems.Products
import com.example.i_restaurant.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private var products = Products()
    private val productList: MutableList<Product> = mutableListOf()
    var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed{ index, value ->
                for (p in value){
                    productList.add(p)
                }
            }

        }

        val recyclerViewProducts = binding.recyclerViewProducts
        recyclerViewProducts.layoutManager = GridLayoutManager( this, 2)
        recyclerViewProducts.setHasFixedSize(true)
        productAdapter = ProductAdapter(this, productList)
        recyclerViewProducts.adapter = productAdapter

        binding.btEntradas.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btEntradas.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btEntradas.setTextColor(Color.WHITE)
                binding.btPrincipais.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPrincipais.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.btBebidas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btBebidas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.btSobremesas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSobremesas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
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
                binding.btEntradas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.btBebidas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btBebidas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.btSobremesas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSobremesas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtListTitle.text = "Principais"
            }
        }

        binding.btBebidas.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btBebidas.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btBebidas.setTextColor(Color.WHITE)
                binding.btPrincipais.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPrincipais.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.btEntradas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btEntradas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.btSobremesas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSobremesas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Bebidas"
            }
        }

        binding.btSobremesas.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btSobremesas.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btSobremesas.setTextColor(Color.WHITE)
                binding.btBebidas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btBebidas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.btPrincipais.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPrincipais.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.btEntradas.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btEntradas.setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Sobremesas"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}