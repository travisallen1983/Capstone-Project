package org.launchcode.semesterassignmentflow.controllers;

import javafx.scene.shape.Path;
import org.launchcode.semesterassignmentflow.models.Assignments;
import org.launchcode.semesterassignmentflow.models.data.AssignmentsDao;
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

    @GetMapping(value = "/")
    public String displayAddAssignments(Model model) {
        model.addAttribute("title", "Fall 2019");

        return "/assignments/assignments";
    }

    @GetMapping(value = "/add")
    public String displayAddAssignmentForm(Model model) {
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("assignments", new Assignments());


        return "/assignments/add";

    }

    @PostMapping(value = "/add")
    public String processAddAssignmentForm(@ModelAttribute @Valid Assignments assignments, Model model, Errors errors) {
        model.addAttribute("title", "Fall 2019");

        if (errors.hasErrors()) {
            model.addAttribute("title", "Fall 2019");
            model.addAttribute("assignments", new Assignments());


            return "/assignments/add";
        }

        assignmentsDao.save(assignments);

        return "redirect:/";

    }

    @GetMapping(value = "remove")
    public String displayRemoveAssignmentForm (Model model){
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("classname","Remove Assignment");
        model.addAttribute("assignments", assignmentsDao.findAll());
        return "/assignments/remove";

    }

    @PostMapping(value = "remove")
    public String processRemoveAssignmentForm ( @RequestParam int[] ids){

        for (int id : ids) {
            assignmentsDao.deleteById(id);
        }

        return  "redirect:/";
    }

    @GetMapping(value = "edit/{assignmentId}")
    public String displayEditForm(Model model, @PathVariable int assignmentId, @ModelAttribute Assignments assignments) {

        model.addAttribute("class", new Assignments());
        model.addAttribute("title", "Edit Assignment " + assignments.getDetails() + " (id=" + assignments.getAssignmentId() + ")");
        return "assignments/edit";
    }

    @PostMapping(value = "edit/{assignmentId}")
    public String processEditForm(@ModelAttribute @Valid Assignments assignments, Model model) {


        return "redirect:";
    }

    @GetMapping(value = "complete")
    public String displayCompletePage(Model model) {

        model.addAttribute("title", "Fall 2019");
        return "assignments/complete";
    }




}

