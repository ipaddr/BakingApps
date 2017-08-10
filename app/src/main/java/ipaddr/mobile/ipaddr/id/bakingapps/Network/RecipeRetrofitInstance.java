package ipaddr.mobile.ipaddr.id.bakingapps.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iip on 7/24/17.
 */

public class RecipeRetrofitInstance {

    public static final String URL = "https://d17h27t6h515a5.cloudfront.net/";

    public static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
