package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import ipaddr.mobile.ipaddr.id.bakingapps.Network.IRecipeAccessNetwork;
import ipaddr.mobile.ipaddr.id.bakingapps.Network.NetworkTask;
import ipaddr.mobile.ipaddr.id.bakingapps.Network.RecipeRetrofitInstance;
import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;
import ipaddr.mobile.ipaddr.id.bakingapps.util.MockData;
import retrofit2.Call;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // The Idling Resource which will be null in production.
    @Nullable private NetworkTask mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ProgressBar(this));
        initNetwork();
//        MockData.DATA = MockData.CONTOH_DATA;
//        startActivity(new Intent(MainActivity.this, RecipeActivity.class));
    }

    void initNetwork(){
        new NetworkTask().execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        /* Do something */
        startActivity(new Intent(MainActivity.this, RecipeActivity.class));
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
        PreferenceManager.getDefaultSharedPreferences(this).getString("ID", "");
    }

    /**
     * Only called from test, creates and returns a new {@link NetworkTask}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new NetworkTask();
        }
        return mIdlingResource;
    }
}
