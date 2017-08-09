package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Step;
import ipaddr.mobile.ipaddr.id.bakingapps.ui.adapter.RecipeStepDetailPagerAdapter;

/**
 * Created by iip on 8/10/17.
 */

public class RecipeStepDetailActivity extends AppCompatActivity {

    public static final String STEPS = "ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeStepDetailActivity.STEPS";

    private ViewPager viewPager;
    private RecipeStepDetailPagerAdapter adapter;

    private List<Step> steps = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_step_detail);
        viewPager = (ViewPager)findViewById(R.id.view_pager);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(STEPS)){
            String ssteps = intent.getStringExtra(STEPS);
            Type type = new TypeToken<List<Step>>(){}.getType();
            steps.clear();
            steps = new GsonBuilder().create().fromJson(ssteps, type);
        }

        adapter = new RecipeStepDetailPagerAdapter(getSupportFragmentManager(), this, steps);
        viewPager.setAdapter(adapter);
    }
}
