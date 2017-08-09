package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import ipaddr.mobile.ipaddr.id.bakingapps.R;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements RecipeFragment.OnFragmentInteractionListener
        , RecipeDetailFragment.OnFragmentInteractionListener {

    private boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
