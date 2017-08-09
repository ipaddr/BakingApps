package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.GsonBuilder;

import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;

/**
 * Created by iip on 8/10/17.
 */

public class RecipeDetailActivity extends AppCompatActivity
        implements RecipeDetailFragment.OnFragmentInteractionListener{

    public static final String RECIPE = "ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeDetailActivity.RECIPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent() != null && getIntent().hasExtra(RECIPE)){
            String recipe = getIntent().getStringExtra(RECIPE);
            init(recipe);
        }
    }

    private void init(String recipe){
        RecipeDetailFragment rdf = RecipeDetailFragment.newInstance(recipe, "");
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, rdf, RecipeFragment.class.getSimpleName());
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
