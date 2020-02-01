package com.filippoengidashet.hybridrecyclerlistspike.model;

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Sat, 2020-02-01 at 16:17.
 */
public class SingleItemSection extends ItemSection {

    public final ListItem item;

    public SingleItemSection(ListItem item) {
        this.item = item;
    }

    @Override
    public int getType() {
        return TYPE_SINGLE_ITEM;
    }
}
