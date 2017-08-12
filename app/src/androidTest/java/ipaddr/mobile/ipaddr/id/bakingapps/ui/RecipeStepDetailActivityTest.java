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
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecipeStepDetailActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void recipeStepDetailActivityTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rv), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView2 = onView(
                withId(R.id.rv_steps));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView = onView(
                allOf(withText("Recipe Introduction"),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("Recipe Introduction")));

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.exo_overlay),
                        childAtPosition(
                                allOf(withId(R.id.recipe_step_detail_video),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction view = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.exo_content_frame),
                                childAtPosition(
                                        withId(R.id.recipe_step_detail_video),
                                        1)),
                        0),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.recipe_step_detail_text), withText("Recipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Recipe Introduction")));

        ViewInteraction textView3 = onView(
                allOf(withText("Starting prep"),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("Starting prep")));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView4 = onView(
                allOf(withText("Recipe Introduction"),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("Recipe Introduction")));

        ViewInteraction textView5 = onView(
                allOf(withText("Starting prep"),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        textView5.check(matches(withText("Starting prep")));

        ViewInteraction textView6 = onView(
                allOf(withText("Prep the cookie crust."),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                2),
                        isDisplayed()));
        textView6.check(matches(withText("Prep the cookie crust.")));

        ViewInteraction frameLayout2 = onView(
                allOf(childAtPosition(
                        withParent(withId(R.id.view_pager)),
                        0),
                        isDisplayed()));
        frameLayout2.check(matches(isDisplayed()));

        ViewInteraction frameLayout3 = onView(
                allOf(childAtPosition(
                        withParent(withId(R.id.view_pager)),
                        0),
                        isDisplayed()));
        frameLayout3.check(matches(isDisplayed()));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.recipe_step_detail_text), withText("1. Preheat the oven to 350°F. Butter a 9\" deep dish pie pan."),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("1. Preheat the oven to 350°F. Butter a 9\" deep dish pie pan.")));

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
