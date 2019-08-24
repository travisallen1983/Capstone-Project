package org.launchcode.semesterassignmentflow.controllers;

import org.launchcode.semesterassignmentflow.models.data.AssignmentsDao;
import org.launchcode.semesterassignmentflow.models.data.ClassesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/class")
public class ClassesController {

    @Autowired
    AssignmentsDao assignmentsDao;

    @Autowired
    ClassesDao classesDao;

    @RequestMapping(value = "/class1")
    public String class1(Model model) {
        model.addAttribute("title", "LaunchCode");
        model.addAttribute("assignments", assignmentsDao.findAll());


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
