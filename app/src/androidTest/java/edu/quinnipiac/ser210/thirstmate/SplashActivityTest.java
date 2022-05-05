package edu.quinnipiac.ser210.thirstmate;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SplashActivityTest {

    @Rule
    public ActivityScenarioRule<SplashActivity> splashActivityActivityTestRule = new ActivityScenarioRule<>(SplashActivity.class);

    @Test
    public void onSplashButtonPressed() {
        onView(withText("I am 21+")).perform(click());
        //check on the next view that some component exists
        onView(withId(R.id.ahoy)).check(matches(withText("Ahoy, Matey!")));
    }
}