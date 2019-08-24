package org.launchcode.semesterassignmentflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/class")
public class ClassesController {

    @RequestMapping(value = "/class1")
    public String class1(Model model) {
        model.addAttribute("title", "HISTORY 401");


        return "classes";
    }
    @RequestMapping(value = "/class2")
    public String class2(Model model) {
        model.addAttribute("title", "HISTORY 401");


        return "classes";
    }
    @RequestMapping(value = "/class3")
    public String class3(Model model) {
        model.addAttribute("title", "HISTORY 401");


        return "classes";
    }
    @RequestMapping(value = "/class4")
    public String class4(Model model) {
        model.addAttribute("title", "HISTORY 401");


        return "classes";
    }

    @RequestMapping(value = "/class5")
    public String class5(Model model) {
        model.addAttribute("title", "HISTORY 401");


        return "classes";
    }


}
