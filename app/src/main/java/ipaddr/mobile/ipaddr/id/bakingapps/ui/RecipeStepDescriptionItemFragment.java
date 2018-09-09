package ipaddr.mobile.ipaddr.id.bakingapps.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.List;

import ipaddr.mobile.ipaddr.id.bakingapps.R;
import ipaddr.mobile.ipaddr.id.bakingapps.model.Step;

/**
 * Created by iip on 8/9/17.
 */

public class RecipeStepDescriptionItemFragment extends Fragment {

    private SimpleExoPlayerView mPlayerView;
    private TextView tvDescirption;
    private SimpleExoPlayer player;

    private static final String PLAYWHENREADY = "PLAYWHENREADY";
    private boolean playWhenReady= true;

    private static final String CURRENTWINDOW = "CURRENTWINDOW";
    private int currentWindow;

    private static final String PLAYBACKPOSITION = "PLAYBACKPOSITION";
    private long playBackPosition;

    private List<Step> steps;
    private String videoURL;
    private String description;

    private static final String VIDEO_URL = "ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeStepDescriptionItemFragment.VIDEO_URL";
    private static final String DESCRIPTION = "ipaddr.mobile.ipaddr.id.bakingapps.ui.RecipeStepDescriptionItemFragment.DESCRIPTION";

    public RecipeStepDescriptionItemFragment(){}

    public static RecipeStepDescriptionItemFragment newInstance(String videoURL, String description){
        RecipeStepDescriptionItemFragment f = new RecipeStepDescriptionItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(VIDEO_URL, videoURL);
        bundle.putString(DESCRIPTION, description);
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            currentWindow = player.getCurrentWindowIndex();
            playBackPosition = player.getCurrentPosition();
        }
        outState.putBoolean(PLAYWHENREADY, playWhenReady);
        outState.putInt(CURRENTWINDOW, currentWindow);
        outState.putLong(PLAYBACKPOSITION, playBackPosition);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(VIDEO_URL) && getArguments().containsKey(DESCRIPTION)){
            Bundle bundle = getArguments();
            videoURL = bundle.getString(VIDEO_URL);
            description = bundle.getString(DESCRIPTION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null){
            playWhenReady = savedInstanceState.getBoolean(PLAYWHENREADY);
            currentWindow = savedInstanceState.getInt(CURRENTWINDOW);
            playBackPosition = savedInstanceState.getLong(PLAYBACKPOSITION);
        }

        View rootView = inflater.inflate(R.layout.fragment_recipe_step_detail, container,false);
        mPlayerView = (SimpleExoPlayerView)rootView.findViewById(R.id.recipe_step_detail_video);
        tvDescirption = (TextView)rootView.findViewById(R.id.recipe_step_detail_text);
        tvDescirption.setText(description);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        hideSystemUI();
        if (Util.SDK_INT > 23){
            iniPlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideSystemUI();
        if (Util.SDK_INT <= 23 || player == null){
            iniPlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23){
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23){
            releasePlayer();
        }
    }

    private void iniPlayer(){
        if (videoURL == null) return;
        player = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(getActivity())
        , new DefaultTrackSelector(), new DefaultLoadControl());
        mPlayerView.setPlayer(player);
        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playBackPosition);

        Uri uri = Uri.parse(videoURL);
        MediaSource mediaSource = buildMediaSource(uri);
        player.prepare(mediaSource);
    }

    private MediaSource buildMediaSource(Uri uri){
        return new ExtractorMediaSource(uri
                , new DefaultHttpDataSourceFactory("ua")
                , new DefaultExtractorsFactory(), null, null);
    }

    private void releasePlayer(){
        if (player != null){
            playWhenReady = player.getPlayWhenReady();
            currentWindow = player.getCurrentWindowIndex();
            playBackPosition = player.getCurrentPosition();
            player.release();
            player = null;
        }
    }

    private void hideSystemUI() {
        mPlayerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
