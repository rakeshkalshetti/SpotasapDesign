package com.spotasapdesign.model;

import com.spotasapdesign.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rakesh on 19/05/17.
 */
public class SongContent {

    public static final List<SongItem> ITEMS = new ArrayList<SongItem>();

    public static final Map<String, SongItem> ITEM_MAP = new HashMap<String, SongItem>();


    static {
        addItem(new SongItem(String.valueOf(1), "emptiness ft. justin tiblekar", "Lorem Ipsum is simply dummy text of the printing and type setting industry ", "18 HOURS AGO", R.drawable.paino));
        addItem(new SongItem(String.valueOf(2), "I'm falling love with you", "Lorem Ipsum is simply dummy text of the printing and type setting industry ", "1 HOURS AGO", R.drawable.dance));

        addItem(new SongItem(String.valueOf(3), "baby ft. justin baber", "Lorem Ipsum is simply dummy text of the printing and type setting industry ", "13 HOURS AGO", R.drawable.guitar));
        addItem(new SongItem(String.valueOf(4), "white horse ft. taylor swift", "Lorem Ipsum is simply dummy text of the printing and type setting industry ", "18 HOURS AGO", R.drawable.sang));
        addItem(new SongItem(String.valueOf(5), "chain smoker new album", "Lorem Ipsum is simply dummy text of the printing and type setting industry ", "6 HOURS AGO", R.drawable.tab));
    }

    private static void addItem(SongItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class SongItem {
        public final String id;
        public final String title;
        public final String details;
        public final String time;
        public final int imageResource;

        public SongItem(String id, String title, String details, String time, int imageResource) {
            this.id = id;
            this.title = title;
            this.details = details;
            this.time = time;
            this.imageResource = imageResource;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
