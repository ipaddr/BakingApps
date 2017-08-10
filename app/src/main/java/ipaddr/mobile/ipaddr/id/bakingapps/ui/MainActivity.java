package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import ipaddr.mobile.ipaddr.id.bakingapps.Network.IRecipeAccessNetwork;
import ipaddr.mobile.ipaddr.id.bakingapps.Network.RecipeRetrofitInstance;
import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;
import ipaddr.mobile.ipaddr.id.bakingapps.util.MockData;
import retrofit2.Call;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ProgressBar(this));
        initNetwork();
    }

    void initNetwork(){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    IRecipeAccessNetwork instance =
                            RecipeRetrofitInstance.getInstance().create(IRecipeAccessNetwork.class);
                    Call<List<Recipe>> recipeCall = instance.getAllRecips();
                    List<Recipe> recipes = recipeCall.execute().body();
                    Type type = new TypeToken<List<Recipe>>(){}.getType();
                    MockData.DATA = new GsonBuilder().create().toJson(recipes, type);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                startActivity(new Intent(MainActivity.this, RecipeActivity.class));
            }
        }.execute();
    }
}
