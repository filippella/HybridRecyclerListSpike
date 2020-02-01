package com.filippoengidashet.hybridrecyclerlistspike.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.filippoengidashet.hybridrecyclerlistspike.R;
import com.filippoengidashet.hybridrecyclerlistspike.model.ItemSection;
import com.filippoengidashet.hybridrecyclerlistspike.model.ListItem;
import com.filippoengidashet.hybridrecyclerlistspike.model.MultiItemSection;
import com.filippoengidashet.hybridrecyclerlistspike.model.SingleItemSection;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Sat, 2020-02-01 at 16:36.
 */
public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ItemSection> sectionList = new ArrayList<>();

    public ItemsAdapter(List<ItemSection> sections) {
        sectionList.addAll(sections);
    }

    @Override
    public int getItemViewType(int position) {
        return sectionList.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        if (viewType == ItemSection.TYPE_SINGLE_ITEM) {
            return new SingleItemViewHolder(li.inflate(R.layout.item_detail_layout, parent, false));
        } else {
            return new MultiItemViewHolder(li.inflate(R.layout.multi_item_layout, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemSection section = sectionList.get(position);
        if (section.getType() == ItemSection.TYPE_SINGLE_ITEM) {
            bindSingleSectionHolder(holder, section);
        } else {
            bindMultiSectionHolder(holder, section);
        }
    }

    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    private void bindMultiSectionHolder(RecyclerView.ViewHolder holder, ItemSection itemSection) {
        MultiItemViewHolder vh = (MultiItemViewHolder) holder;
        MultiItemSection mis = (MultiItemSection) itemSection;
        vh.bind(mis);
    }

    private void bindSingleSectionHolder(RecyclerView.ViewHolder holder, ItemSection itemSection) {
        SingleItemViewHolder vh = (SingleItemViewHolder) holder;
        SingleItemSection sis = (SingleItemSection) itemSection;
        vh.bind(sis);
    }

    class SingleItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView wallpaperImageView;

        SingleItemViewHolder(@NonNull View itemView) {
            super(itemView);
            wallpaperImageView = itemView.findViewById(R.id.imageView);
        }

        void bind(SingleItemSection section) {
            ListItem item = section.item;

            Glide.with(itemView.getContext().getApplicationContext())
                    .load(item.profile_picture_link)
                    .into(wallpaperImageView);
        }
    }

    class MultiItemViewHolder extends RecyclerView.ViewHolder {

        private final ItemsPagerAdapter pagerAdapter = new ItemsPagerAdapter();
        private boolean binded = false;

        MultiItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ViewPager pager = itemView.findViewById(R.id.itemsPager);
            pager.setAdapter(pagerAdapter);
            pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    System.out.println("Selected_Side_Page position -> " + position);
                }
            });

            PageIndicatorView indicator = itemView.findViewById(R.id.indicator);
            indicator.setViewPager(pager);
        }

        void bind(MultiItemSection section) {
            if (binded) return;
            pagerAdapter.setItemList(section.getItemList());
            binded = true;
        }
    }
}
