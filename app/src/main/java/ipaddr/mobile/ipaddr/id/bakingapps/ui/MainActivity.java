package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, RecipeActivity.class));
    }
}
