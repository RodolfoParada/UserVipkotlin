package com.rodolfo.uservip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.rodolfo.uservip.UserVipApplication.Companion.prefs
import com.rodolfo.uservip.databinding.ActivityMainBinding
import com.rodolfo.uservip.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
        fun initUI() {
            binding.btnBack.setOnClickListener {
                prefs.wipe()
                onBackPressed()
            }
            val userName = prefs.getName()
          binding.tvName.text = "Bienvenido $userName"
            if (prefs.getVIP()) {
                setVIPColorBackground()
            }
        }

        fun setVIPColorBackground() {
            binding.container.setBackgroundColor(ContextCompat.getColor(this,R.color.vip_yellow)) //es posible que design_default_color_primary genere error
        }
    }
