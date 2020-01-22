package wooliesX.com.tipcalc

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class tipTest {


    @Rule @JvmField
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun Step01_enterBillAmount(){
        onView(withId(R.id.billEditText)).perform(typeText("40"))
    }

    @Test
    fun Step02_enterTipPercentage(){
        onView(withId(R.id.tipPercentageEditText)).perform(typeText("10"))
    }

    @Test
    fun Step03_calculateTip(){
        onView(withId(R.id.calculateButton)).perform(click())
    }

    @Test
    fun Step04_validateCalculatedTip(){
        onView(withId(R.id.infoTextView)).check(matches(withText("Tip: $4.00 Total: $44.00")))
    }

}