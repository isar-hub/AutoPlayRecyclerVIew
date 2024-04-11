package com.example.autoplayrecyclerview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;

import java.util.ArrayList;

public class MediaRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MediaObject> mediaObjects;
    private RequestManager requestManager;
    public MediaRecyclerAdapter(ArrayList<MediaObject> mediaObjects,
                                RequestManager requestManager) {
        this.mediaObjects = mediaObjects;
        this.requestManager = requestManager;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_media_list_item, viewGroup, false));
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MediaRecyclerAdapter.MyViewHolder) viewHolder).onBind(mediaObjects.get(i), requestManager);
    }
    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        /**
         * below view have public modifier because
         * we have access PlayerViewHolder inside the ExoPlayerRecyclerView
         */
        public FrameLayout mediaContainer;
        public ImageView mediaCoverImage, volumeControl;
        public ProgressBar progressBar;
        public RequestManager requestManager;
        private TextView title, userHandle;
        private View parent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView;
            mediaContainer = itemView.findViewById(R.id.mediaContainer);
            mediaCoverImage = itemView.findViewById(R.id.ivMediaCoverImage);
            title = itemView.findViewById(R.id.tvTitle);
            userHandle = itemView.findViewById(R.id.tvUserHandle);
            progressBar = itemView.findViewById(R.id.progressBar);
            volumeControl = itemView.findViewById(R.id.ivVolumeControl);
        }
        void onBind(MediaObject mediaObject, RequestManager requestManager) {
            this.requestManager = requestManager;
            parent.setTag(this);
            title.setText(mediaObject.getTitle());
            userHandle.setText(mediaObject.getUserHandle());
            this.requestManager
                    .load("https://picsum.photos/id/1/200/300")
                    .into(mediaCoverImage);
        }
    }
}