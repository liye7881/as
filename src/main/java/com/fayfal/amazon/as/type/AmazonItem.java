package com.fayfal.amazon.as.type;

/**
 * Created by yeyeli on 3/9/17.
 */
public class AmazonItem
{
    private String title;
    private String url;
    private double price;
    private String skus;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getSkus()
    {
        return skus;
    }

    public void setSkus(String skus)
    {
        this.skus = skus;
    }
}
