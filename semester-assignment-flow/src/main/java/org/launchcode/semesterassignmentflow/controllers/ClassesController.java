package org.launchcode.semesterassignmentflow.controllers;

import org.launchcode.semesterassignmentflow.models.Classes;
import org.launchcode.semesterassignmentflow.models.data.AssignmentsDao;
import org.launchcode.semesterassignmentflow.models.data.ClassesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/class")
public class ClassesController {

    @Autowired
    AssignmentsDao assignmentsDao;

    @Autowired
    ClassesDao classesDao;


    @GetMapping(value = "/")
    public String displayAddClasses(Model model) {
        model.addAttribute("title", "Fall 2019");

        return "/classes/classes";
    }


    @GetMapping(value = "/add")
    public String displayAddClassForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("classes", new Classes());


        return "/classes/add";
    }

    @PostMapping(value = "/add")
    public String processAddClassForm(@ModelAttribute @Valid Classes classes, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");

        if (errors.hasErrors()) {
            model.addAttribute("title", "Fall 2019");
            model.addAttribute("classes", new Classes());
            return "/classes/add";
        }

        classesDao.save(classes);

        return  "redirect:/";
    }


    @GetMapping(value = "/remove")
    public String displayRemoveClassesForm(Model model) {
        model.addAttribute("title", "Remove Class");
        model.addAttribute("classes", classesDao.findAll());
        return "/classes/remove";

    }

    @PostMapping(value = "/remove")
    public String processRemoveClassesForm(@RequestParam int[] ids) {

        for (int id : ids) {
            classesDao.deleteById(id);
        }
        return  "redirect:/";
    }


    @RequestMapping(value = "/{classId}")
    public String class1(Model model, @PathVariable int classId) {
        model.addAttribute("title", "{classId}");
        model.addAttribute("assignments", assignmentsDao.findAll());


        return "/classes/classes";
    }
}
