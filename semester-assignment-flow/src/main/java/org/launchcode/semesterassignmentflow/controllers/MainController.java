package org.launchcode.semesterassignmentflow.controllers;

import org.launchcode.semesterassignmentflow.models.User;
import org.launchcode.semesterassignmentflow.models.data.AssignmentsDao;
import org.launchcode.semesterassignmentflow.models.data.ClassesDao;
import org.launchcode.semesterassignmentflow.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    ClassesDao classesDao;

    @Autowired
    AssignmentsDao assignmentsDao;

    @Autowired
    UsersDao usersDao;

    @GetMapping(value = "/")
    public String homepage(Model model, @ModelAttribute User user) {
        model.addAttribute("title", "Fall 2019");
        //user.getSemester()
        model.addAttribute("classes", classesDao.findAll());
        model.addAttribute("assignments", assignmentsDao.findAll());

            //, @RequestParam int[] ids
            //for (int id : ids) {
            //    assignmentsDao.deleteById(id);
            //}
           //return  "redirect:/";

        return "home";
    }


    @GetMapping(value = "/signin")
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("user", new User());


        return "/users/signin";

    }



    @PostMapping(value = "/signin")
    public String processLoginForm(@ModelAttribute @Valid User user, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");

        if(errors.hasErrors()) {

            model.addAttribute("title", "Fall 2019");
            model.addAttribute("user", new User());

            return "/users/signin";

        }

        return "/users/signin";
    }

    @GetMapping(value = "/register")
    public String displayRegisterForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("user", new User());


        return "/users/register";

    }



    @PostMapping(value = "/register")
    public String processRegisterForm(@ModelAttribute @Valid User user, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");

        if(errors.hasErrors()) {

            model.addAttribute("title", "Fall 2019");
            model.addAttribute("user", new User());

            return "/users/register";

        }

        usersDao.save(user);

        return "redirect:";
    }

    @GetMapping(value = "/semester")
    public String displaySemesterForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("user", new User());


        return "/users/semester";

    }



    @PostMapping(value = "/semester")
    public String processSemesterForm(@ModelAttribute @Valid User user, Model model) {

        usersDao.save(user);
        return "redirect:";
    }



    }

