package com.fayfal.amazon.as;

import com.fayfal.amazon.as.json.AmazonPriceResponseParser;
import com.fayfal.amazon.as.type.AmazonItem;
import junit.framework.TestCase;

import java.io.InputStream;
import java.util.List;

/**
 * Created by yeyeli on 3/9/17.
 */
public class AmazonPriceResponseParserTest extends TestCase
{
    private InputStream input;

    @Override
    protected void setUp() throws Exception
    {
        input = Thread.currentThread().getContextClassLoader().getResourceAsStream("sampleResponse.json");
    }

    public void testParse()
    {
        AmazonPriceResponseParser parser = new AmazonPriceResponseParser();
        List<AmazonItem> result = parser.parse(input);
        assertNotNull(result);

    }
}
