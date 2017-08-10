package ipaddr.mobile.ipaddr.id.bakingapps.Network;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.test.espresso.IdlingResource;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;
import ipaddr.mobile.ipaddr.id.bakingapps.util.MockData;
import retrofit2.Call;

/**
 * Created by iip on 8/10/17.
 */

public class NetworkTask extends AsyncTask<Void, Void, Void> implements IdlingResource {

    @Nullable private volatile ResourceCallback mCallback;

    // Idleness is controlled with this boolean.
    private AtomicBoolean mIsIdleNow = new AtomicBoolean(true);

    @Override
    protected Void doInBackground(Void... params) {
        try {
            IRecipeAccessNetwork instance =
                    RecipeRetrofitInstance.getInstance().create(IRecipeAccessNetwork.class);
            Call<List<Recipe>> recipeCall = instance.getAllRecips();
            List<Recipe> recipes = recipeCall.execute().body();
            Type type = new TypeToken<List<Recipe>>(){}.getType();
            MockData.DATA = new GsonBuilder().create().toJson(recipes, type);
            EventBus.getDefault().post(MockData.DATA);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdleNow.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallback = callback;
    }

    /**
     * Sets the new idle state, if isIdleNow is true, it pings the {@link ResourceCallback}.
     * @param isIdleNow false if there are pending operations, true if idle.
     */
    public void setIdleState(boolean isIdleNow) {
        mIsIdleNow.set(isIdleNow);
        if (isIdleNow && mCallback != null) {
            mCallback.onTransitionToIdle();
        }
    }
}
