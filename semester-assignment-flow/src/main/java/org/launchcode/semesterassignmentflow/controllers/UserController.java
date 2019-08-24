package org.launchcode.semesterassignmentflow.controllers;

import org.launchcode.semesterassignmentflow.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("user", new User());


        return "signin";

    }



    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String processLoginForm(@ModelAttribute @Valid User user, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");

        if(errors.hasErrors()) {

            model.addAttribute("title", "Fall 2019");
            model.addAttribute("user", new User());

            return "signin";

        }

        return "signin";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String displayRegisterForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("user", new User());


        return "register";

    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegisterForm(@ModelAttribute @Valid User user, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");

        if(errors.hasErrors()) {

            model.addAttribute("title", "Fall 2019");
            model.addAttribute("user", new User());

            return "register";

        }

        return "register";
    }
}


