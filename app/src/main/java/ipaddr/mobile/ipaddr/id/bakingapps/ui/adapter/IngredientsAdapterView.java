package ipaddr.mobile.ipaddr.id.bakingapps.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Ingredient;

/**
 * Created by iip on 7/31/17.
 */

public class IngredientsAdapterView extends RecyclerView.Adapter<IngredientsAdapterView.IngredientsViewHolder>{

    private Context context;
    private List<Ingredient> ingredients;

    public IngredientsAdapterView(List<Ingredient> ingredients){
        this.ingredients = new ArrayList<>();
        this.ingredients.addAll(ingredients);
    }

    @Override
    public IngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        IngredientsViewHolder ingredientsViewHolder = new IngredientsViewHolder(view);
        return ingredientsViewHolder;
    }

    @Override
    public void onBindViewHolder(IngredientsViewHolder holder, int position) {
        final Ingredient ingredient = ingredients.get(position);
        holder.name.setText(String.format(context.getString(R.string.ingredients_detail)
                , ingredient.getQuantity(), ingredient.getMeasure(), ingredient.getIngredient()));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    static class IngredientsViewHolder extends ViewHolder{

        @BindView(android.R.id.text1)
        TextView name;

        public IngredientsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
