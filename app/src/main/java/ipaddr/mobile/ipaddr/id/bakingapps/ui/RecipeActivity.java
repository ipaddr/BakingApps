package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ipaddr.mobile.ipaddr.id.bakingapps.R;

/**
 * Created by iip on 8/10/17.
 */

public class RecipeActivity extends AppCompatActivity implements RecipeFragment.OnFragmentInteractionListener{

    private boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        initRecipeFragment();
    }

    private void initRecipeFragment(){
        RecipeFragment rf = new RecipeFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, rf, RecipeFragment.class.getSimpleName());
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
