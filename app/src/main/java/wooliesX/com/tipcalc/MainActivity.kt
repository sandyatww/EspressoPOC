package wooliesX.com.tipcalc

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.activity_main.*
//import sun.jvm.hotspot.utilities.IntArray


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCenter.start(
            application, "b7e9d021-df5d-4131-95c9-4184f16ecadf",
            Analytics::class.java, Crashes::class.java
        )
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
