package ru.bert7438.aplserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bert7438.aplserver.models.Progress;
import ru.bert7438.aplserver.models.Users;
import ru.bert7438.aplserver.repo.ProgressRepo;
import ru.bert7438.aplserver.repo.UserRepo;

import java.util.Random;


@Controller
public class UsersController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProgressRepo progressRepo;

    @GetMapping("/users")
    public String usersPage(Model model){
        Iterable<Users> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }

    @GetMapping("/users/add")
    public String usersAdd(Model model){
        model.addAttribute("UserForm", new Users());
        return "users_add";
    }

    @PostMapping("/users/add")
    public String usersPost(@ModelAttribute("UserForm") Users userForm, BindingResult bindingResult, Model model){
        userRepo.saveAndFlush(userForm);
        for(int i = 0; i < 8; i++){
            String les = "Занятие №" + String.valueOf(i+1);
            String lec = "Лекция №" + String.valueOf(i+1);
            Progress new_progress = new Progress(les, lec,
                    0, 0, "null", "null", (userForm.getId()));
            progressRepo.saveAndFlush(new_progress);
        }
        return "redirect:/users";
    }
}
