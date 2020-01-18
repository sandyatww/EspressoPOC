package wooliesX.com.tipcalc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        infoTextView.visibility = View.INVISIBLE

        calculateButton.setOnClickListener {
           infoTextView.visibility = View.VISIBLE

            val bill = billEditText.text.toString().toDouble()
            val tipPercentage = tipPercentageEditText.text.toString().toDouble()
            val tip = (bill * tipPercentage /100)
            val total = tip + bill;
            infoTextView.text = "Tip: ${doubleToDollar(tip)} Total: ${doubleToDollar(total)}"
        }
    }

    fun doubleToDollar(number: Double) : String{
        return "$" + String.format("%.2f", number)
    }
}
