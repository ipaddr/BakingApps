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
public class RecipeDetailActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void recipeDetailActivityTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rv), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.cv_ingredients),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

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
                allOf(withId(android.R.id.text1), withText("6.00 TBLSP of unsalted butter, melted"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("6.00 TBLSP of unsalted butter, melted")));

        ViewInteraction textView3 = onView(
                allOf(withId(android.R.id.text1), withText("0.50 CUP of granulated sugar"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("0.50 CUP of granulated sugar")));

        ViewInteraction textView4 = onView(
                allOf(withId(android.R.id.text1), withText("1.50 TSP of salt"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                3),
                        isDisplayed()));
        textView4.check(matches(withText("1.50 TSP of salt")));

        ViewInteraction textView5 = onView(
                allOf(withId(android.R.id.text1), withText("5.00 TBLSP of vanilla"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                4),
                        isDisplayed()));
        textView5.check(matches(withText("5.00 TBLSP of vanilla")));

        ViewInteraction textView6 = onView(
                allOf(withId(android.R.id.text1), withText("1.00 K of Nutella or other chocolate-hazelnut spread"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                5),
                        isDisplayed()));
        textView6.check(matches(withText("1.00 K of Nutella or other chocolate-hazelnut spread")));

        ViewInteraction textView7 = onView(
                allOf(withId(android.R.id.text1), withText("500.00 G of Mascapone Cheese(room temperature)"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                6),
                        isDisplayed()));
        textView7.check(matches(withText("500.00 G of Mascapone Cheese(room temperature)")));

        ViewInteraction textView8 = onView(
                allOf(withId(android.R.id.text1), withText("1.00 CUP of heavy cream(cold)"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                7),
                        isDisplayed()));
        textView8.check(matches(withText("1.00 CUP of heavy cream(cold)")));

        ViewInteraction textView9 = onView(
                allOf(withId(android.R.id.text1), withText("4.00 OZ of cream cheese(softened)"),
                        childAtPosition(
                                allOf(withId(R.id.rv_ingredients),
                                        childAtPosition(
                                                withId(R.id.cv_ingredients),
                                                0)),
                                8),
                        isDisplayed()));
        textView9.check(matches(withText("4.00 OZ of cream cheese(softened)")));

        ViewInteraction viewGroup = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rv_steps),
                                0),
                        0),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.step_short_description), withText("Recipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView10.check(matches(withText("Recipe Introduction")));

        ViewInteraction viewGroup2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rv_steps),
                                1),
                        0),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.step_short_description), withText("Starting prep"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView11.check(matches(withText("Starting prep")));

        ViewInteraction viewGroup3 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rv_steps),
                                2),
                        0),
                        isDisplayed()));
        viewGroup3.check(matches(isDisplayed()));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.step_short_description), withText("Prep the cookie crust."),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView12.check(matches(withText("Prep the cookie crust.")));

        ViewInteraction viewGroup4 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rv_steps),
                                3),
                        0),
                        isDisplayed()));
        viewGroup4.check(matches(isDisplayed()));

        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.step_short_description), withText("Press the crust into baking form."),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView13.check(matches(withText("Press the crust into baking form.")));

        ViewInteraction viewGroup5 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rv_steps),
                                1),
                        0),
                        isDisplayed()));
        viewGroup5.check(matches(isDisplayed()));

        ViewInteraction imageView5 = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.step_short_description), withText("Press the crust into baking form."),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView14.check(matches(withText("Press the crust into baking form.")));

        ViewInteraction viewGroup6 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rv_steps),
                                2),
                        0),
                        isDisplayed()));
        viewGroup6.check(matches(isDisplayed()));

        ViewInteraction imageView6 = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.step_short_description), withText("Start filling prep"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView15.check(matches(withText("Start filling prep")));

        ViewInteraction viewGroup7 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rv_steps),
                                3),
                        0),
                        isDisplayed()));
        viewGroup7.check(matches(isDisplayed()));

        ViewInteraction imageView7 = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView7.check(matches(isDisplayed()));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.step_short_description), withText("Finish filling prep"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView16.check(matches(withText("Finish filling prep")));

        ViewInteraction viewGroup8 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rv_steps),
                                4),
                        0),
                        isDisplayed()));
        viewGroup8.check(matches(isDisplayed()));

        ViewInteraction imageView8 = onView(
                allOf(withId(R.id.step_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView8.check(matches(isDisplayed()));

        ViewInteraction textView17 = onView(
                allOf(withId(R.id.step_short_description), withText("Finishing Steps"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView17.check(matches(withText("Finishing Steps")));

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
