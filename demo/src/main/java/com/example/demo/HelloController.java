package com.example.demo;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Person;
import com.example.demo.repository.PersonRepository;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;


@Controller
public class HelloController {
    
    @Autowired
    PersonRepository repository;

    @Autowired
    PersonDaoImpl dao;

    @RequestMapping("/")
    public ModelAndView index(@ModelAttribute("formModel") Person person , ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("title", "Hello Page");
        mav.addObject("msg", "this is JPA sample data");
        java.util.List<Person> list = repository.findAll();
        mav.addObject("data" ,list);
        return mav;
    }

    @RequestMapping(value = "/", method=RequestMethod.POST)
    @Transactional
    public ModelAndView form(@ModelAttribute("formModel") Person person, ModelAndView mav, BindingResult result) {
        if(!result.hasErrors()) {
            repository.saveAndFlush(person);
            return new ModelAndView("redirect:/");
        } else {
            mav.setViewName("index");
            mav.addObject("title", "Hello Page");
            mav.addObject("msg", "this is JPA sample data");
            return mav;
        }
    }
    
    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute("formModel") Person person, ModelAndView mav, @PathVariable int id) {
        mav.setViewName("edit");
        mav.addObject("title", "edit Person");
        Optional<Person> data = repository.findById(id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @RequestMapping(value = "/edit", method=RequestMethod.POST)
    public ModelAndView requestMethodName(@RequestAttribute("formModel") Person person, ModelAndView mav) {
        repository.saveAndFlush(person);
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping( value = "/find", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("find");
        mav.addObject("title", "Hello Page");
        mav.addObject("msg", "this is JPA sample data");
        Iterable<Person> list = dao.getAll();
        mav.addObject("data", list);
        return mav;
    }
    
    @RequestMapping( value = "/find", method=RequestMethod.POST)
    public ModelAndView search(ModelAndView mav, HttpServletRequest request) {
        mav.setViewName("find");
        String param = request.getParameter("find_str");
        if (param == "") {
            mav = new ModelAndView("redirect:/find");
        } else {
            mav.addObject("title", "find result");
            mav.addObject("msg", "「" + param + "」の検索結果");
            mav.addObject("value", param);
            Person data = dao.findById(Integer.parseInt(param));
            Person[] list = new Person[] {data};
            mav.addObject("data", list);
        }
        return mav;
    }
    
    
}
