package com.filippoengidashet.hybridrecyclerlistspike;

import com.filippoengidashet.hybridrecyclerlistspike.mapper.ListMapper;
import com.filippoengidashet.hybridrecyclerlistspike.model.Constants;
import com.filippoengidashet.hybridrecyclerlistspike.model.ItemSection;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Sat, 2020-02-01 at 15:54.
 */
public class ListMapperTest {

    private ListMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new ListMapper();
    }

    @Test
    public void mapItems() throws JSONException {

        String json = Constants.RESPONSE;

        List<ItemSection> itemSections = mapper.mapItems(json);

        System.out.println(itemSections);
    }

    @After
    public void tearDown() throws Exception {
        mapper = null;
    }
}
