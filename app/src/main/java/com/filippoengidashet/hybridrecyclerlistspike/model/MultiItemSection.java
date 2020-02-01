package com.filippoengidashet.hybridrecyclerlistspike.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Sat, 2020-02-01 at 16:18.
 */
public class MultiItemSection extends ItemSection {

    private final List<ListItem> itemList = new ArrayList<>();

    public MultiItemSection(List<ListItem> items) {
        itemList.addAll(items);
    }

    public List<ListItem> getItemList() {
        return itemList;
    }

    @Override
    public int getType() {
        return TYPE_MULTI_ITEM;
    }
}
