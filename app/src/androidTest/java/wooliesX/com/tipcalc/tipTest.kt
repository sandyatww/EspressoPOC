package wooliesX.com.tipcalc

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.ext.junit.runners.AndroidJUnit4


@RunWith(AndroidJUnit4::class)
class tipTest {

    @Rule @JvmField
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun validateTip(){
        onView(withId(R.id.billEditText)).perform(typeText("40"))
        onView(withId(R.id.tipPercentageEditText)).perform(typeText("10"))
        onView(withId(R.id.calculateButton)).perform(click())
        onView(withId(R.id.infoTextView)).check(matches(withText("Tip: $4.00 Total: $44.00")))
    }



}