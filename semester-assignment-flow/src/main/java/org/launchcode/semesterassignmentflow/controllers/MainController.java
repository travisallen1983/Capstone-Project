package org.launchcode.semesterassignmentflow.controllers;

import org.launchcode.semesterassignmentflow.models.Assignments;
import org.launchcode.semesterassignmentflow.models.Classes;
import org.launchcode.semesterassignmentflow.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class MainController {
    @RequestMapping(value = "/")
    public String homepage(Model model) {
        model.addAttribute("title", "Fall 2019");


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


        return "class-results";
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


        return "assignment-results";

    }

}