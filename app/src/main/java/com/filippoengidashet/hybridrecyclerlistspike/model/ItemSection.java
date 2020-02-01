package com.filippoengidashet.hybridrecyclerlistspike.model;

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Sat, 2020-02-01 at 16:17.
 */
public abstract class ItemSection {

    public static int TYPE_SINGLE_ITEM = 0;
    public static int TYPE_MULTI_ITEM = 1;

    public abstract int getType();
}
