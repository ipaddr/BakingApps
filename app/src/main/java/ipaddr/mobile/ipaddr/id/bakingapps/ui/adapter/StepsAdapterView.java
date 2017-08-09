package ipaddr.mobile.ipaddr.id.bakingapps.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Step;
import ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeStepDetailFragment;

/**
 * Created by iip on 7/31/17.
 */

public class StepsAdapterView extends RecyclerView.Adapter<StepsAdapterView.StepsViewHolder> {

    private Context context;
    private List<Step> steps;

    public StepsAdapterView(List<Step> steps){
        this.steps = new ArrayList<>();
        this.steps.addAll(steps);
    }

    @Override
    public StepsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.step_adapter_view, parent, false);
        StepsViewHolder stepsViewHolder = new StepsViewHolder(view);
        return stepsViewHolder;
    }

    @Override
    public void onBindViewHolder(StepsViewHolder holder, int position) {
        final Step step = steps.get(position);

        if (step.getThumbnailURL() != null && !TextUtils.isEmpty(step.getThumbnailURL())){
            Picasso.with(context)
                    .load(step.getThumbnailURL())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.ivStepImage);
        } else {
            holder.ivStepImage.setImageResource(R.mipmap.ic_launcher);
        }

        holder.tvShortDiscriptoin.setText(step.getShortDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = RecipeStepDetailFragment.newInstance(step.getVideoURL(), step.getDescription());
                FragmentTransaction ft = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, f);
                ft.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    static class StepsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.step_image)
        ImageView ivStepImage;
        @BindView(R.id.step_short_description)
        TextView tvShortDiscriptoin;

        public StepsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
