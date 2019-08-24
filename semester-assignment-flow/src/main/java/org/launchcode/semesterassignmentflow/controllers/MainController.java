package org.launchcode.semesterassignmentflow.controllers;

import org.launchcode.semesterassignmentflow.models.Assignments;
import org.launchcode.semesterassignmentflow.models.Classes;
import org.launchcode.semesterassignmentflow.models.User;
import org.launchcode.semesterassignmentflow.models.data.AssignmentsDao;
import org.launchcode.semesterassignmentflow.models.data.ClassesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    ClassesDao classesDao;

    @Autowired
    AssignmentsDao assignmentsDao;

    @RequestMapping(value = "/")
    public String homepage(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("classes", classesDao.findAll());
        model.addAttribute("assignments", assignmentsDao.findAll());


        return "home";
    }

    @RequestMapping(value = "/addclass", method = RequestMethod.GET)
    public String displayAddClassForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("classes", new Classes());


        return "add-class";
    }

    @RequestMapping(value = "/addclass", method = RequestMethod.POST)
    public String processAddClassForm(@ModelAttribute @Valid Classes classes, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");

        if (errors.hasErrors()) {
            model.addAttribute("title", "Fall 2019");
            model.addAttribute("classes", new Classes());
            return "add-class";
        }

        classesDao.save(classes);

        return "redirect:";
    }

    @RequestMapping(value = "/addassignment", method = RequestMethod.GET)
    public String displayAddAssignmentForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("assignments", new Assignments());


        return "add-assignment";

    }

    @RequestMapping(value = "/addassignment", method = RequestMethod.POST)
    public String processAddAssignmentForm(@ModelAttribute @Valid Assignments assignments, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");

        if (errors.hasErrors()) {
            model.addAttribute("title", "Fall 2019");
            model.addAttribute("assignments", new Assignments());


            return "add-assignment";
        }

        assignmentsDao.save(assignments);

        return "redirect:";

    }


    @RequestMapping(value = "removeclass", method = RequestMethod.GET)
    public String displayRemoveClassesForm(Model model) {
        model.addAttribute("title", "Remove Class");
        model.addAttribute("classes", classesDao.findAll());
        return "remove-class";

    }

    @RequestMapping(value = "removeclass", method = RequestMethod.POST)
    public String processRemoveClassesForm(@RequestParam int[] ids) {

        for (int id : ids) {
            classesDao.deleteById(id);
        }
        return "redirect:";
    }

        @RequestMapping(value = "removeassignment", method = RequestMethod.GET)
        public String displayRemoveAssignmentForm (Model model){
            model.addAttribute("title", "Remove Assignment");
            model.addAttribute("assignments", assignmentsDao.findAll());
            return "remove-assignments";

        }

        @RequestMapping(value = "removeassignment", method = RequestMethod.POST)
        public String processRemoveAssignmentForm ( @RequestParam int[] ids){

            for (int id : ids) {
                assignmentsDao.deleteById(id);
            }

            return "redirect:";
        }
    }

