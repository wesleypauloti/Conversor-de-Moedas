package com.example.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private  lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)
        val buttonConvert = findViewById<Button>(R.id.btn_convert)
        val buttonMenu = findViewById<Button>(R.id.btn_menu)

        buttonMenu.setOnClickListener{
            PopupMenu(this@MainActivity, buttonMenu).apply {
                menuInflater.inflate(R.menu.meu_menu, this.menu)
                setOnMenuItemClickListener {
                    Toast.makeText(this@MainActivity, "${it.title} foi clicado", Toast.LENGTH_SHORT).show()
                    true
                }
                show()
            }
        }

        buttonConvert.setOnClickListener {
            convert()
        }

    }
    private fun convert() {
        val selectedCurrency = findViewById<RadioGroup>(R.id.radioGroup)

        val checked = selectedCurrency.checkedRadioButtonId

        val currency = when(checked) {
            R.id.usd -> "USD"
            R.id.eur -> "EUR"
            else     -> "CLP"
        }
        val editField = findViewById<EditText>(R.id.txt_value)
        val value = editField.text.toString()

        if (value.isEmpty()) return

        result.text = value
        result.visibility = View.VISIBLE
    }
}