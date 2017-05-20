package com.spotasapdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spotasapdesign.R;
import com.spotasapdesign.model.SongContent;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Rakesh on 19/05/17.
 */

public class SongPagerAdapter extends android.support.v4.view.PagerAdapter {

    private Context mContext;
    private List<SongContent.SongItem> items;

    public SongPagerAdapter(Context context, List<SongContent.SongItem> items) {
        mContext = context;
        this.items = items;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = (View) inflater.inflate(R.layout.pager_layout, viewGroup, false);

        ImageView albumImageView = (ImageView) view.findViewById(R.id.albumImageView);
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        TextView detailTextView = (TextView) view.findViewById(R.id.detailTextView);

        SongContent.SongItem songItem = items.get(position);
        if(songItem != null) {
            albumImageView.setImageResource(songItem.imageResource);
            titleTextView.setText(songItem.title);
            detailTextView.setText(songItem.details);
        }


        viewGroup.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "";
    }
}
