package android.mobile.ipaddr.id.bakingapps.Network;

import android.mobile.ipaddr.id.bakingapps.model.Recipes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by iip on 7/24/17.
 */

public interface IRecipeAccessNetwork {

    @GET()
    Call<Recipes> getAllRecips();

}
