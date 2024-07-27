package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

@RequestMapping
public class SampleController {
    
    public String index(org.springframework.ui.Model model) {
        model.addAttribute("msg", "これはサンプルです");
        return "index";
    }

    @RequestMapping("/{num}")
    public String index(@PathVariable int num , org.springframework.ui.Model model) {
        int res = 0;
        for (int i = 1; i < num; i++) {
            res += i;
        }
        model.addAttribute("msg", "total: " + res);
        return "index";
    }

    @RequestMapping("/{num}")
    public ModelAndView index(@PathVariable int num , ModelAndView mav) {
        int res = 0;
        for (int i = 1; i < num; i++) {
            res += i;
        }
        mav.addObject("msg", "total: " + res);
        mav.setViewName("index");
        return mav;
    }
}
