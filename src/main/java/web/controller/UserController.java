package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserController(){}


    @GetMapping(value="/users")
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers",userService.getAll());
        return "users";
    }

    @GetMapping(value="users/add")
    public String addUser(@RequestParam("name") String name
            , @RequestParam("surname") String surname
            , @RequestParam("age") int age, Model model) {
        model.addAttribute("user",userService.save(name, surname, age));
        return "addForm";
    }

    @GetMapping(value="/id")
    public String getUserById(@RequestParam("id") int id, Model model) {
        model.addAttribute("user",userService.getById(id));
        return "user";
    }

    @PostMapping(value="/update")
    public String updateUser(@RequestParam("name") String name
            , @RequestParam("surname") String surname
            , @RequestParam("age") int age, Model model) {
        model.addAttribute("user",userService.update(name, surname, age));
        return "redirect:/users";
    }

    @PostMapping(value="/delete")
    public String deleteUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("deleteUser", userService.delete(id));
        return "redirect:/users";
    }




}
