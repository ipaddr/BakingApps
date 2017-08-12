package ipaddr.mobile.ipaddr.id.bakingapps;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAction.*;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.google.android.exoplayer2.upstream.AssetDataSource;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;

import ipaddr.mobile.ipaddr.id.bakingapps.ui.MainActivity;
import ipaddr.mobile.ipaddr.id.bakingapps.ui.adapter.RecipeAdapterView;
import ipaddr.mobile.ipaddr.id.bakingapps.util.MockData;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by iip on 8/10/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private IdlingResource mIdlingResource;

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule
            = new IntentsTestRule<MainActivity>(MainActivity.class);

    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityRule.getActivity().getIdlingResource();
        // To prove that the test fails, omit this call:
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void testLaunchRecipeActivity(){
        // Verify that an intent to the dialer was sent with the correct action, phone
        // number and package. Think of Intents intended API as the equivalent to Mockito's verify.
        intending(allOf(
                hasComponent(hasShortClassName(".RecipeActivity"))));
    }

    @Test
    public void test(){
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
        onView(withId(R.id.rv)).check(matches(isDisplayed()));

    }

    @Test
    public void verifyData(){
        onView(withText("Nutella Pie")).check(matches(isDisplayed()));

        onView(withText("Brownies")).check(matches(isDisplayed()));

        onView(withText("Yellow Cake")).check(matches(isDisplayed()));

        onView(withText("Cheesecake")).check(matches(isDisplayed()));
    }

    @Test
    public void verifyNutellaPie(){
        onView(withText("Nutella Pie")).perform(click());
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_ingredients)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_steps)).check(matches(isDisplayed()));

    }

    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }

}
