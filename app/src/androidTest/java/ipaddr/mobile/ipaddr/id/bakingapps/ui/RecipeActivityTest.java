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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecipeActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void recipeActivityTest() {
        ViewInteraction progressBar = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.content),
                                childAtPosition(
                                        withId(R.id.decor_content_parent),
                                        1)),
                        0),
                        isDisplayed()));
        progressBar.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.recipe_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withText("Baking Apps"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Baking Apps")));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.recipe_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.recipe_name), withText("Nutella Pie"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Nutella Pie")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.recipe_ingredients), withText("Ingredients: 9"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("Ingredients: 9")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.recipe_steps), withText("Steps: 7"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                3),
                        isDisplayed()));
        textView4.check(matches(withText("Steps: 7")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.recipe_servings), withText("Servings: 8"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                4),
                        isDisplayed()));
        textView5.check(matches(withText("Servings: 8")));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.recipe_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.recipe_name), withText("Brownies"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView6.check(matches(withText("Brownies")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.recipe_ingredients), withText("Ingredients: 10"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView7.check(matches(withText("Ingredients: 10")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.recipe_steps), withText("Steps: 10"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                3),
                        isDisplayed()));
        textView8.check(matches(withText("Steps: 10")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.recipe_servings), withText("Servings: 8"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                4),
                        isDisplayed()));
        textView9.check(matches(withText("Servings: 8")));

        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.recipe_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.recipe_name), withText("Yellow Cake"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView10.check(matches(withText("Yellow Cake")));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.recipe_ingredients), withText("Ingredients: 10"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView11.check(matches(withText("Ingredients: 10")));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.recipe_steps), withText("Steps: 13"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                3),
                        isDisplayed()));
        textView12.check(matches(withText("Steps: 13")));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.recipe_servings), withText("Servings: 8"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                4),
                        isDisplayed()));
        textView13.check(matches(withText("Servings: 8")));

        ViewInteraction imageView5 = onView(
                allOf(withId(R.id.recipe_image),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.recipe_name), withText("Cheesecake"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView14.check(matches(withText("Cheesecake")));

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.recipe_ingredients), withText("Ingredients: 9"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView15.check(matches(withText("Ingredients: 9")));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.recipe_steps), withText("Steps: 13"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                3),
                        isDisplayed()));
        textView16.check(matches(withText("Steps: 13")));

        ViewInteraction textView17 = onView(
                allOf(withId(R.id.recipe_servings), withText("Servings: 8"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                4),
                        isDisplayed()));
        textView17.check(matches(withText("Servings: 8")));

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
