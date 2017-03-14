package com.fayfal.amazon.as.json;

import com.fayfal.amazon.as.type.AmazonItem;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeyeli on 3/9/17.
 */
@Component
public class AmazonPriceResponseParser
{
    public List<AmazonItem> parse(String input)
    {
        return doParse(JSONObject.fromObject(input));
    }

    public List<AmazonItem> parse(InputStream inputStream)
    {
        StringWriter writer = new StringWriter();
        try
        {
            IOUtils.copy(inputStream, writer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return parse(writer.toString());
    }

    protected List<AmazonItem> doParse(JSONObject root)
    {
        List<AmazonItem> result = new ArrayList<>();

        JSONObject dealDetails = root.getJSONObject("dealDetails");
        if (dealDetails != null)
        {
            for (Object dealDetailKey : dealDetails.keySet())
            {
                JSONObject dealDetail = (JSONObject) dealDetails.get(dealDetailKey);

                String title = dealDetail.getString("title");
                String url = dealDetail.getString("egressUrl");

                JSONArray items = dealDetail.getJSONArray("items");
                if (items != null && items.size() != 0)
                {
                    for (int i = 0; i < items.size(); i++)
                    {
                        JSONObject item = items.getJSONObject(i);
                        double dealPrice = item.getDouble("dealPrice");
                        String variationDimensions = item.getString("variationDimensions");
                        String sku = variationDimensions == null ? "" : variationDimensions;
                        sku = "null".equals(sku) ? "{}": sku;

                        AmazonItem amazonItem = new AmazonItem();
                        amazonItem.setTitle(title);
                        amazonItem.setUrl(url);
                        amazonItem.setPrice(dealPrice);
                        amazonItem.setSkus(sku);

                        result.add(amazonItem);
                    }
                }
            }
        }

        return result;
    }
}
