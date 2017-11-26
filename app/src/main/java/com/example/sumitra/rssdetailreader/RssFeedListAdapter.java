package com.example.sumitra.rssdetailreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import static android.R.id.list;

/**
 * Created by sumitra on 11/13/2017.
 */

public class RssFeedListAdapter extends RecyclerView.Adapter<RssFeedListAdapter.FeedModelViewHolder>{

    private List<RssFeedModel> mRssFeedModels;
    Context context;
    private MainActivity mActivity;

    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        private View rssFeedView;

        public FeedModelViewHolder(View v) {
            super(v);
            rssFeedView = v;
        }
    }

    public RssFeedListAdapter( List<RssFeedModel> rssFeedModels) {
        mRssFeedModels = rssFeedModels;
        //this.mListener=listener;
        //this.context=context;
    }

    @Override
    public FeedModelViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rss_feed, parent, false);
        FeedModelViewHolder holder = new FeedModelViewHolder(v);
        return holder;
    }



    @Override
    public void onBindViewHolder(FeedModelViewHolder holder, final int position) {
        final RssFeedModel rssFeedModel = mRssFeedModels.get(position);
        ((TextView)holder.rssFeedView.findViewById(R.id.titleText)).setText(rssFeedModel.title);
        ((TextView)holder.rssFeedView.findViewById(R.id.descriptionText)).setText(rssFeedModel.description);
        ((TextView)holder.rssFeedView.findViewById(R.id.linkText)).setText(rssFeedModel.link);

        //on click
       holder.rssFeedView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


              Intent intent=new Intent(v.getContext(),DetailedView.class);
               String title=rssFeedModel.title;
               intent.putExtra("FeedData", rssFeedModel);
               v.getContext().startActivity(intent);


           }
       });
    }

    @Override
    public int getItemCount() {
        return mRssFeedModels.size();
    }

    @Override
    public void onViewAttachedToWindow(FeedModelViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }


}

