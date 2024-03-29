package com.example.ladm_p7_timermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.ladm_p7_timermenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit  var binding: ActivityMainBinding //para binding
        var contador=0

        val timer = object : CountDownTimer(20000,1000){
            override fun onTick(p0: Long) {
                //Se ejecuta cuando el intervalo=0
                binding.resultado.setText("Contador ${contador++}")
            }

            override fun onFinish() {
                //Se ejecuta cuando el total=0
                start()
            }

        }

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //para binding
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)//para binding

        binding.ejecutar.setOnClickListener {
            timer.start()
        }
    }

    //Toodo objeto grafrico de XML debe inflarce para poder cliquearse
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.acerca->{Toast.makeText(this,"Cliqueaste",Toast.LENGTH_LONG).show()}
            R.id.salir->{finish()}
        }
        return true
    }
}