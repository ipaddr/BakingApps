package ipaddr.mobile.ipaddr.id.bakingapps.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ipaddr.mobile.ipaddr.id.bakingapps.model.Step;
import ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeStepDescriptionItemFragment;

/**
 * Created by iip on 8/10/17.
 */

public class RecipeStepDetailPagerAdapter extends FragmentPagerAdapter {

    Context context;
    List<Step> steps;

    public RecipeStepDetailPagerAdapter(FragmentManager fm, Context context, List<Step> steps) {
        super(fm);
        this.context = context;
        this.steps = new ArrayList<>();
        this.steps.addAll(steps);
    }

    @Override
    public Fragment getItem(int position) {
        Step step = steps.get(position);
        String videoURL = step.getVideoURL();
        String description = step.getDescription();
        return RecipeStepDescriptionItemFragment.newInstance(videoURL, description);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Step step = steps.get(position);
        return step.getShortDescription();
    }

    @Override
    public int getCount() {
        return steps.size();
    }
}
