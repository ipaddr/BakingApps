package ipaddr.mobile.ipaddr.id.bakingapps.ui;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ipaddr.mobile.ipaddr.id.bakingapps.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.fragment_container),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rv), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.text1), withText("2.00 CUP of Graham Cracker crumbs"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("2.00 CUP of Graham Cracker crumbs")));

        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.text1), withText("2.00 CUP of Graham Cracker crumbs"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("2.00 CUP of Graham Cracker crumbs")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.step_short_description), withText("Recipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("Recipe Introduction")));

        ViewInteraction textView4 = onView(
                allOf(withId(android.R.id.text1), withText("1.00 CUP of heavy cream(cold)"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                7),
                        isDisplayed()));
        textView4.check(matches(withText("1.00 CUP of heavy cream(cold)")));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
