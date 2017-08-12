package ipaddr.mobile.ipaddr.id.bakingapps.ui.adapter;

import android.content.Context;
import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Recipe;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeDetailActivity;
import ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeDetailFragment;
import ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeFragment;

/**
 * Created by iip on 7/24/17.
 */

public class RecipeAdapterView extends RecyclerView.Adapter<RecipeAdapterView.RecipeViewHolder> {

    private Context context;
    private List<Recipe> recipes;

    public RecipeAdapterView(List<Recipe> recipes){
        this.recipes = new ArrayList<>();
        this.recipes.addAll(recipes);
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recipe_overview, parent, false);
        RecipeViewHolder recipeViewHolder = new RecipeViewHolder(view);
        return recipeViewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        final Recipe recipe = recipes.get(position);

        if (recipe.getImage() != null && !TextUtils.isEmpty(recipe.getImage()))
        Picasso.with(context)
                .load(recipe.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.image);

        holder.name.setText(recipe.getName());
        holder.ingredients.setText(String.format(context.getString(R.string.ingredients), String.valueOf(recipe.getIngredients().size())));
        holder.steps.setText(String.format(context.getString(R.string.steps), String.valueOf(recipe.getSteps().size())));
        holder.servings.setText(String.format(context.getString(R.string.servings), String.valueOf(recipe.getServings())));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecipeDetailActivity.class);
                intent.putExtra(RecipeDetailActivity.RECIPE, new GsonBuilder().create().toJson(recipe));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.recipe_image) ImageView image;
        @BindView(R.id.recipe_name) TextView name;
        @BindView(R.id.recipe_ingredients) TextView ingredients;
        @BindView(R.id.recipe_steps) TextView steps;
        @BindView(R.id.recipe_servings) TextView servings;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
