package ipaddr.mobile.ipaddr.id.bakingapps.Network;

import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by iip on 7/24/17.
 */

public interface IRecipeAccessNetwork {

    @GET()
    Call<Recipe> getAllRecips();

}
