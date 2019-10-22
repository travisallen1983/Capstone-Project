package org.launchcode.semesterassignmentflow.controllers;

import org.launchcode.semesterassignmentflow.models.Assignments;
import org.launchcode.semesterassignmentflow.models.Classes;
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
import java.util.List;

@Controller
@RequestMapping(value = "/class")
public class ClassesController {

    @Autowired
    AssignmentsDao assignmentsDao;

    @Autowired
    ClassesDao classesDao;

    @Autowired
    UsersDao usersDao;

    @GetMapping(value = "/")
    public String displayAddClasses(Model model) {


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
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("classname", "Remove Class");
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
    public String newclass(Model model, @PathVariable int classId) {

        Classes classes = classesDao.findOne(classId);
        List<Assignments> assignments = classes.getAssignments();
        model.addAttribute("classname", classes.getName());
        model.addAttribute("title", "Fall 2019");
        model.addAttribute("assignments", assignmentsDao.findAll());



        return "/classes/classes";
    }



    @GetMapping(value = "edit/{classId}")
    public String displayEditForm(Model model, @PathVariable int classId, @ModelAttribute Classes classes) {

        model.addAttribute("class", new Classes());
        model.addAttribute("title", "Edit Cheese " + classes.getName() + " (id=" + classes.getClassId() + ")");
        return "classes/edit";
    }

    @PostMapping(value = "edit/{classId}")
    public String processEditForm(@ModelAttribute @Valid Classes classes, Model model) {


        return "redirect:/cheese";
    }
}
