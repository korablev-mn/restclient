package ru.korablev.restclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.korablev.restclient.model.Role;
import ru.korablev.restclient.model.User;
import ru.korablev.restclient.service.RoleService;
import ru.korablev.restclient.service.UserService;
import ru.korablev.restclient.util.ListRoles;
import java.security.Principal;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService restUserService;

    @Autowired
    private RoleService restRoleService;

    @GetMapping("/home")
    public String home(
            Model model,
            @ModelAttribute("theUser") User user,
            Principal login) {
        List<User> userList = new ArrayList<>();
        userList = restUserService.findAll();
        model.addAttribute("list", userList);
        ListRoles roles = new ListRoles();
        model.addAttribute("listRole", roles.getListRole());
        return "home";
    }

    @GetMapping("/admin/showFormForUpdate")
    public String showFormForUpdate(
            @RequestParam("userId") Long theId
    ) {
        return "redirect:/home";
    }

    @GetMapping("/admin/delete")
    public String delete(
            @RequestParam("userId") Long theId
    ) {
        restUserService.deleteById(theId);
        return "redirect:/home";
    }

    @PostMapping("/admin/save")
    public String saveEmployee(
            @RequestParam(value = "role") String role,
            @ModelAttribute("theUser") User user
    ) {
        try {
            Set<Role> roles = new HashSet<>();
                  Optional<Role> theRole = restRoleService.findAll().stream()
                    .filter( p -> p.getRole().equals(role))
                    .findFirst();
            roles.add(theRole.get());
            user.setRoles(roles);
            restUserService.save(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }
}