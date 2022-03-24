package ru.bert7438.aplserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bert7438.aplserver.models.Progress;
import ru.bert7438.aplserver.models.Users;
import ru.bert7438.aplserver.repo.ProgressRepo;
import ru.bert7438.aplserver.repo.UserRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ProgressController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProgressRepo progressRepo;

    @GetMapping("/progress_lessons/edit")
    public String progress_lessons(Model model){
        Iterable<Progress> progress = progressRepo.findAll();
        Iterable<Users> users = userRepo.findAll();
        Map<String, ArrayList<Progress>> attrMap = new HashMap<>();
        int ind = 0;
        for(Users i: users){
            ArrayList<Progress> progressList = (ArrayList<Progress>) progressRepo.findProgressesByIdUserEquals(i.getId());
            String n = "us"+ ind;
            attrMap.put(n, progressList);
            ind++;
        }
        model.addAttribute("progress", progress);
        model.addAttribute("users", users);
        model.addAllAttributes(attrMap);
        return "progress_lessons_edit";
    }

    @GetMapping("/progress_lectures_edit")
    public String progress_lectures(Model model){
        Iterable<Progress> progress = progressRepo.findAll();
        Iterable<Users> users = userRepo.findAll();
        model.addAttribute("progress", progress);
        model.addAttribute("users", users);
        return "progress_lectures_edit";
    }
}
