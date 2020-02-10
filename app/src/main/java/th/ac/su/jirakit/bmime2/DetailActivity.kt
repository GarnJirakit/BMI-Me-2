package th.ac.su.jirakit.bmime2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bmi = intent.getDoubleExtra("share",0.0)
        val result = intent.getStringExtra("result")
        val weight = intent.getDoubleExtra("weight",0.0)
        val height = intent.getDoubleExtra("height",0.0)

        var bmiNum = findViewById<TextView>(R.id.BMI1)
        bmiNum.setText(bmi.round(2).toString())

        var display = findViewById<TextView>(R.id.BMI2)
        display.setText(result)

        var detail = findViewById<TextView>(R.id.BMI3)
        detail.setText(" height " + height +" weight "+ weight)

        var share = findViewById<Button>(R.id.btnShare)

        share.setOnClickListener {

            var value = "My BMI is "+ bmi.round(2) +"("+result+")"

            var intent = Intent();
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,value)
            intent.type = "text/plan"

            startActivity(Intent.createChooser(intent,"Share"))

            startActivity(intent)
        }
        var btnback = findViewById<Button>(R.id.btnX)
        btnback.setOnClickListener {
            finish()
        }
    }
    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }
}