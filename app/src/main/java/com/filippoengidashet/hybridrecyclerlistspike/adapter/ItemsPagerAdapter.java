package com.filippoengidashet.hybridrecyclerlistspike.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.filippoengidashet.hybridrecyclerlistspike.R;
import com.filippoengidashet.hybridrecyclerlistspike.model.ListItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Sat, 2020-02-01 at 17:07.
 */
public class ItemsPagerAdapter extends PagerAdapter {

    private final List<ListItem> itemList = new ArrayList<>();

    @Override
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater li = LayoutInflater.from(container.getContext());
        View itemView = li.inflate(R.layout.item_detail_layout, null);

        ImageView wallpaperImageView = itemView.findViewById(R.id.imageView);

        ListItem item = itemList.get(position);

        Glide.with(itemView.getContext().getApplicationContext())
                .load(item.profile_picture_link)
                .into(wallpaperImageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Pos - " + position;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    public void setItemList(List<ListItem> items) {
        //check difference here
        itemList.clear();
        itemList.addAll(items);
        notifyDataSetChanged();
    }
}
