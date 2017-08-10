package ipaddr.mobile.ipaddr.id.bakingapps.Network;

import java.util.List;

import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by iip on 7/24/17.
 */

public interface IRecipeAccessNetwork {

    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> getAllRecips();

}
