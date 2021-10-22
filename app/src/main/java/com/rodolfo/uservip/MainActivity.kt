package com.rodolfo.uservip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodolfo.uservip.UserVipApplication.Companion.prefs
import com.rodolfo.uservip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         initUI()
         checkUserValues()
    }
    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }
    fun initUI(){
          binding.btnContinue.setOnClickListener{accessToDetail()}
    }
    fun accessToDetail(){
        if(binding.etName.text.toString().isNotEmpty()) {
            prefs.saveName(binding.etName.text.toString())
            prefs.saveVip(binding.cbVip.isChecked)
            goToDetail()
        }else{
        }
    }
    fun goToDetail(){
        startActivity(Intent(this,ResultActivity::class.java))
    }
}