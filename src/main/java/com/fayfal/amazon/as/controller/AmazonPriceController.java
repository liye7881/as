package com.fayfal.amazon.as.controller;

import com.fayfal.amazon.as.controller.dto.AmazonPriceDto;
import com.fayfal.amazon.as.json.AmazonPriceResponseParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yeyeli on 3/9/17.
 */
@Controller
@RequestMapping("price")
public class AmazonPriceController
{
    @Autowired
    private AmazonPriceResponseParser parser;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(ModelAndView mv, @ModelAttribute("singleDto") AmazonPriceDto dto)
    {
        mv.setViewName("priceInput");

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(ModelAndView mv, @ModelAttribute("singleDto") AmazonPriceDto dto)
    {
        String input = dto.getInput();
        if (input == null || input.trim().equals(""))
        {
            return get(mv, dto);
        }
        try
        {
            dto.setItems(parser.parse(input));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return get(mv, dto);
        }
        mv.setViewName("priceOutput");
        return mv;
    }
}
