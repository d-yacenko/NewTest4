package com.samsung.itschool.newtest4;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BtnTest {
    private String stringToBetyped;
    private int salt = new Random().nextInt(999);
    private String result =salt+",TEST1:OK";;


    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        stringToBetyped = String.format("%03d", new Integer(salt).hashCode());
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.et))
                .perform(typeText(stringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.btn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.tv))
                .check(matches(withText(stringToBetyped)));

        Log.d("IT School Samsung","=============================");
        Log.d("IT School Samsung","ВАШ РЕЗУЛЬТАТ: "+result.hashCode()+""+salt);
        Log.d("IT School Samsung","=============================");

    }

}
