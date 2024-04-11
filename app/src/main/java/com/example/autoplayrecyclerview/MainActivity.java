package com.example.autoplayrecyclerview;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ExoPlayerRecyclerView mRecyclerView;
    private ArrayList<MediaObject> mediaObjectList = new ArrayList<>();
    private MediaRecyclerAdapter mAdapter;
    private boolean firstTime = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        // Prepare demo content
        prepareVideoList();
        //set data object
        mRecyclerView.setMediaObjects(mediaObjectList);
        mAdapter = new MediaRecyclerAdapter(mediaObjectList, initGlide());
        //Set Adapter
        mRecyclerView.setAdapter(mAdapter);
        if (firstTime) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    mRecyclerView.playVideo(false);
                }
            });
            firstTime = false;
        }
    }
    private void initView() {
        mRecyclerView = findViewById(R.id.exoPlayerRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions();
        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }
    @Override
    protected void onDestroy() {
        if (mRecyclerView != null) {
            mRecyclerView.releasePlayer();
        }
        super.onDestroy();
    }
    private void prepareVideoList() {
        MediaObject mediaObject = new MediaObject();
        mediaObject.setId(1);
        mediaObject.setUserHandle("@h.pandya");
        mediaObject.setTitle(
                "Do you think the concept of marriage will no longer exist in the future?");
        mediaObject.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-1.png");
        mediaObject.setUrl("https://d3sgyc22r791ef.cloudfront.net/Activities/VID-20240320-WA0004.mp4");
        MediaObject mediaObject2 = new MediaObject();
        mediaObject2.setId(2);
        mediaObject2.setUserHandle("@hardik.patel");
        mediaObject2.setTitle(
                "If my future husband doesn't cook food as good as my mother should I scold him?");
        mediaObject2.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-2.png");
        mediaObject.setUrl("https://d3sgyc22r791ef.cloudfront.net/Activities/VID-20240320-WA0004.mp4");
        MediaObject mediaObject3 = new MediaObject();
        mediaObject3.setId(3);
        mediaObject3.setUserHandle("@arun.gandhi");
        mediaObject3.setTitle("Give your opinion about the Ayodhya temple controversy.");
        mediaObject3.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-3.png");
        mediaObject.setUrl("https://d3sgyc22r791ef.cloudfront.net/Activities/VID-20240320-WA0004.mp4");
        MediaObject mediaObject4 = new MediaObject();
        mediaObject4.setId(4);
        mediaObject4.setUserHandle("@sachin.patel");
        mediaObject4.setTitle("When did kama founders find sex offensive to Indian traditions");
        mediaObject4.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-4.png");
        mediaObject.setUrl("https://d3sgyc22r791ef.cloudfront.net/Activities/VID-20240320-WA0004.mp4");
        MediaObject mediaObject5 = new MediaObject();
        mediaObject5.setId(5);
        mediaObject5.setUserHandle("@monika.sharma");
        mediaObject5.setTitle("When did you last cry in front of someone?");
        mediaObject5.setCoverUrl(
                "https://androidwave.com/media/images/exo-player-in-recyclerview-in-android-5.png");
        mediaObject.setUrl("https://d3sgyc22r791ef.cloudfront.net/Activities/VID-20240320-WA0004.mp4");
        mediaObjectList.add(mediaObject);
        mediaObjectList.add(mediaObject2);
        mediaObjectList.add(mediaObject3);
        mediaObjectList.add(mediaObject4);
        mediaObjectList.add(mediaObject5);
        mediaObjectList.add(mediaObject);
        mediaObjectList.add(mediaObject2);
        mediaObjectList.add(mediaObject3);
        mediaObjectList.add(mediaObject4);
        mediaObjectList.add(mediaObject5);
    }
}