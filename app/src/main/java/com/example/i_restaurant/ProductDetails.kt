package com.example.i_restaurant

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.i_restaurant.databinding.ActivityProductDetailsBinding
import java.text.DecimalFormat

class ProductDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    var amount = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        val imgProduct = intent.extras!!.getInt("imgProduct")
        val name = intent.extras!!.getString("name")
        val price = intent.extras!!.getString("price")!!.toDouble()
        var newPrice = price
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.imgProduct.setBackgroundResource(imgProduct)
        binding.txtProductName.text = "$name"
        binding.txtProductPrice.text = decimalFormat.format(price)

        binding.btBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btIncrease.setOnClickListener {
            if (amount == 1){
                binding.txtAmount.text = "2"
                newPrice += price
                amount = 2
            }else if (amount == 1){
            binding.txtAmount.text = "3"
            newPrice += price
            amount = 3
        }
            binding.txtProductPrice.text = decimalFormat.format(newPrice)

        }

        binding.btToDecrease.setOnClickListener {
            if (amount == 3){
                binding.txtAmount.text = "2"
                newPrice - price
                amount = 2
            }else if (amount == 2){
                binding.txtAmount.text = "1"
                newPrice -= price
                amount = 1
            }
            binding.txtProductPrice.text = decimalFormat.format(newPrice)

        }

        binding.btConfirm.setOnClickListener{

            val CocaLata:RadioButton = binding.btCocaLata
            val FantaLata:RadioButton = binding.btFantaLata
            val PepsiLata:RadioButton = binding.btPepsiLata

            val latas = when{
                CocaLata.isChecked -> {
                    "Coca Lata"
                }
                FantaLata.isChecked -> {
                    "Fanta Lata"
                }
                PepsiLata.isChecked -> {
                    "Pepsi Lata"
                }
                else ->{
                    ""
                }
            }
            val intent = Intent(this, Finish::class.java)
            intent.putExtra("name", name)
            intent.putExtra("amount", amount)
            intent.putExtra("total", newPrice)
            intent.putExtra("latas", latas)
            startActivity(intent)
        }
    }
}