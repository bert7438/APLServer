package ru.bert7438.aplserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bert7438.aplserver.models.Users;
import ru.bert7438.aplserver.repo.ProgressRepo;
import ru.bert7438.aplserver.repo.UserRepo;


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
}
