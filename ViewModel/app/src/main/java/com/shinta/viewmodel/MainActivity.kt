package com.shinta.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.shinta.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    // bisa juga begini

//    private val viewModel: MainViewModel by viewModel ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // untuk membuat instance dari kelas MainViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        // menghubungkan ke button nya
        activityMainBinding.btnCalculate.setOnClickListener{
            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()
            val length = activityMainBinding.edtLength.text.toString()

            // pengecekan
            when{
                width.isEmpty() -> {
                    activityMainBinding.edtWidth.error = "still empty"
                }
                height.isEmpty() -> {
                    activityMainBinding.edtHeight.error = "still empty"
                }
                length.isEmpty() -> {
                    activityMainBinding.edtLength.error = "still empty"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}