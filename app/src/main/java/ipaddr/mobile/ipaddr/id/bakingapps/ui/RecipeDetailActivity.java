package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Type;
import java.util.List;

import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;
import ipaddr.mobile.ipaddr.id.bakingapps.model.SelectedPosition;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Step;
import ipaddr.mobile.ipaddr.id.bakingapps.ui.adapter.RecipeStepDetailPagerAdapter;

/**
 * Created by iip on 8/10/17.
 */

public class RecipeDetailActivity extends AppCompatActivity
        implements RecipeDetailFragment.OnFragmentInteractionListener{

    public static final String RECIPE = "ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeDetailActivity.RECIPE";

    private String sRecipe;
    private Recipe recipe;
    private boolean mTwoPane;

    private ViewPager viewPager;
    private RecipeStepDetailPagerAdapter adapter;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RECIPE, new GsonBuilder().create().toJson(recipe));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        if (savedInstanceState != null){
            sRecipe = savedInstanceState.getString(RECIPE);
            recipe = new GsonBuilder().create().fromJson(sRecipe, Recipe.class);
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent() != null && getIntent().hasExtra(RECIPE)){
            sRecipe = getIntent().getStringExtra(RECIPE);
            recipe = new GsonBuilder().create().fromJson(sRecipe, Recipe.class);
        }

        if (findViewById(R.id.view_pager) != null){
            mTwoPane = true;
            initMasterDetail(savedInstanceState, sRecipe, recipe);
        } else {
            mTwoPane = false;
            init(savedInstanceState, sRecipe);
        }
    }

    private void init(Bundle savedInstanceState, String recipe){
        if (savedInstanceState == null) {
            RecipeDetailFragment rdf = RecipeDetailFragment.newInstance(recipe, mTwoPane);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_container, rdf, RecipeFragment.class.getSimpleName());
            ft.commit();
        }
    }

    private void initMasterDetail(Bundle savedInstanceState, String SRecipe, Recipe recipe){
        init(savedInstanceState, sRecipe);
        initViewPager(savedInstanceState, recipe.getSteps());
    }

    private void initViewPager(Bundle savedInstanceState, List<Step> steps){
//        if (savedInstanceState == null){
            viewPager = (ViewPager)findViewById(R.id.view_pager);
            adapter = new RecipeStepDetailPagerAdapter(getSupportFragmentManager(), this, steps);
            viewPager.setAdapter(adapter);
//        }
    }

    @Override
    public void onFragmentMasterSelected(int position) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SelectedPosition selectedPosition) {
        /* Do something */
        viewPager.setCurrentItem(selectedPosition.getPosition());
    }

}
