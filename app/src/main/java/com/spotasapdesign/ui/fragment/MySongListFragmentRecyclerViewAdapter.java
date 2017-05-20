package com.spotasapdesign.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spotasapdesign.R;
import com.spotasapdesign.model.SongContent.SongItem;

import java.util.List;

/**
 * Created by Rakesh on 19/05/17.
 */
public class MySongListFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MySongListFragmentRecyclerViewAdapter.ViewHolder> {

    private final List<SongItem> mValues;

    public MySongListFragmentRecyclerViewAdapter(List<SongItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_songlistfragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        if(holder.mItem != null) {
            holder.titleTextView.setText(holder.mItem.title);
            holder.timeTextView.setText(holder.mItem.time);
            holder.detailTextView.setText(holder.mItem.details);
            holder.albumImageView.setImageResource(holder.mItem.imageResource);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public SongItem mItem;

        private TextView titleTextView;
        private TextView timeTextView;
        private TextView detailTextView;

        private ImageView albumImageView;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            timeTextView = (TextView) view.findViewById(R.id.timeTextView);
            detailTextView = (TextView) view.findViewById(R.id.detailTextView);

            albumImageView = (ImageView) view.findViewById(R.id.albumImageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + timeTextView.getText() + "'";
        }
    }
}
