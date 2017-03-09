package com.fayfal.amazon.as.controller.dto;

import com.fayfal.amazon.as.type.AmazonItem;

import java.util.List;

/**
 * Created by yeyeli on 3/9/17.
 */
public class AmazonPriceDto
{
    private String input;
    private List<AmazonItem> items;

    public String getInput()
    {
        return input;
    }

    public void setInput(String input)
    {
        this.input = input;
    }

    public List<AmazonItem> getItems()
    {
        return items;
    }

    public void setItems(List<AmazonItem> items)
    {
        this.items = items;
    }
}
