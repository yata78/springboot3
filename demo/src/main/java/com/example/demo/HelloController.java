package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
    private boolean flag = false;

    @RequestMapping("/")
    public ModelAndView requestMethodName(ModelAndView mav) {
        flag = !flag;
        mav.setViewName("index");
        mav.addObject("flag", flag);
        mav.addObject("msg", "サンプルです");
        return mav;
    }
    
}
