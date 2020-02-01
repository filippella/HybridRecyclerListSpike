package com.filippoengidashet.hybridrecyclerlistspike.mapper;

import com.filippoengidashet.hybridrecyclerlistspike.model.ItemSection;
import com.filippoengidashet.hybridrecyclerlistspike.model.ListItem;
import com.filippoengidashet.hybridrecyclerlistspike.model.MultiItemSection;
import com.filippoengidashet.hybridrecyclerlistspike.model.SingleItemSection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Sat, 2020-02-01 at 15:53.
 */
public class ListMapper {

    public List<ItemSection> mapItems(String jsonResponse) throws JSONException {

        List<ItemSection> sectionList = new ArrayList<>();

        JSONObject o = new JSONObject(jsonResponse);
        String msg = o.getString("Msg");
        System.out.println(msg);

        JSONObject dObj = o.getJSONObject("dictionary_today");

        Iterator<String> objKeys = dObj.keys();

        while (objKeys.hasNext()) {
            String phoneNumber = objKeys.next();
            System.out.println("Number -> " + phoneNumber);

            List<ListItem> itemList = new ArrayList<>();

            JSONArray items = dObj.getJSONArray(phoneNumber);

            int length = items.length();
            for (int i = 0; i < length; i++) {
                JSONObject itemObject = items.getJSONObject(i);
                System.out.println("\t [ " + (i + 1) + " ]" + itemObject.getString("_id"));

                ListItem listItem = new ListItem();

                listItem._id = itemObject.getString("_id");
                listItem.phone_no = itemObject.getString("phone_no");
                listItem.user_name = itemObject.getString("user_name");
                listItem.wallpaper_link = itemObject.getString("wallpaper_link");
                listItem.wallpaper_likes_counter = itemObject.getInt("wallpaper_likes_counter");
                listItem.date_time = itemObject.getString("date_time");
                listItem.profile_picture_link = itemObject.getString("profile_picture_link");
                listItem.FavouriteImage = itemObject.getBoolean("FavouriteImage");

                itemList.add(listItem);
            }

            int size = itemList.size();

            if (size > 0) {
                if (size == 1) {
                    //create a single item section
                    sectionList.add(new SingleItemSection(itemList.get(0)));
                } else {
                    //create a scrollable list section
                    sectionList.add(new MultiItemSection(itemList));
                }
            }
        }
        return sectionList;
    }
}
