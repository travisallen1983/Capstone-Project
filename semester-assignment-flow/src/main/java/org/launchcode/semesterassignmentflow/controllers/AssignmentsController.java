package org.launchcode.semesterassignmentflow.controllers;
import org.launchcode.semesterassignmentflow.models.Assignments;
import org.launchcode.semesterassignmentflow.models.data.AssignmentsDao;
import org.launchcode.semesterassignmentflow.models.data.ClassesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/assignments")
public class AssignmentsController {

    @Autowired
    AssignmentsDao assignmentsDao;

    @Autowired
    ClassesDao classesDao;

    @GetMapping(value = "/")
    public String displayAddAssignments(Model model) {
        model.addAttribute("classes", classesDao.findAll());
        model.addAttribute("title", "Fall 2019");

        return "/assignments/assignments";
    }

    @GetMapping(value = "/add")
    public String displayAddAssignmentForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("classes", classesDao.findAll());
        model.addAttribute("assignments", new Assignments());


        return "/assignments/add";

    }

    @PostMapping(value = "/add")
    public String processAddAssignmentForm(@ModelAttribute @Valid Assignments assignments, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("classes", classesDao.findAll());

        if (errors.hasErrors()) {
            model.addAttribute("title", "Fall 2019");
            model.addAttribute("classes", classesDao.findAll());
            model.addAttribute("assignments", new Assignments());


            return "/assignments/add";
        }

        assignmentsDao.save(assignments);

        return "redirect:/";

    }


    @GetMapping(value = "/{assignmentId}")
    public String displayEditForm(Model model,  @PathVariable int assignmentId) {

        Assignments assignments = assignmentsDao.findOne(assignmentId);
        model.addAttribute("class", new Assignments());
        model.addAttribute("classes", classesDao.findAll());
        model.addAttribute("title", "Fall 2019");
        // Edit Assignment " + assignments.getDetails() + " (id=" + assignments.getAssignmentId() + ")")
        return "assignments/edit";
    }

    @PostMapping(value = "/{assignmentId}")
    public String processEditForm(@ModelAttribute @Valid Assignments assignments, Model model) {


        return "redirect:";
    }

    @GetMapping(value = "complete")
    public String displayCompletePage(Model model) {

        model.addAttribute("title", "Fall 2019");
        model.addAttribute("classes", classesDao.findAll());
        return "assignments/complete";
    }




}

