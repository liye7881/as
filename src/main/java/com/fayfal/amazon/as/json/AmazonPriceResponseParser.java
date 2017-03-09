package com.fayfal.amazon.as.json;

import com.fayfal.amazon.as.type.AmazonItem;
import org.springframework.stereotype.Component;

import javax.json.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        return parse(inputStream);
    }

    public List<AmazonItem> parse(InputStream inputStream)
    {
        return doParse(Json.createReader(inputStream).readObject());
    }

    protected List<AmazonItem> doParse(JsonObject root)
    {
        List<AmazonItem> result = new ArrayList<>();

        JsonObject dealDetails = root.getJsonObject("dealDetails");
        if (dealDetails != null)
        {
            for (String dealDetailKey : dealDetails.keySet())
            {
                JsonObject dealDetail = dealDetails.get(dealDetailKey).asJsonObject();

                String title = dealDetail.getString("title");
                String url = dealDetail.getString("egressUrl");

                JsonArray items = dealDetail.getJsonArray("items");
                if (items != null && items.size() != 0)
                {
                    for (int i = 0; i < items.size(); i++)
                    {
                        JsonObject item = items.getJsonObject(i);
                        double dealPrice = item.getJsonNumber("dealPrice").doubleValue();
                        JsonValue variationDimensions = item.get("variationDimensions");
                        String sku = variationDimensions == null ? "" : variationDimensions.toString();
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
