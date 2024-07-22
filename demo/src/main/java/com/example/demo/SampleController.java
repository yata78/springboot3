package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
