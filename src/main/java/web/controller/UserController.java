package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.entity.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping(value="/")
    public ModelAndView getAllUsers() {
        List<User> users = userService.getAll();
        ModelAndView view = new ModelAndView();
        view.setViewName("allUsers");
        view.addObject("usersList", users);
        return view;
    }

    @GetMapping(value="users/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/users");
        userService.add(user);
        return view;
    }

    @GetMapping(value="/id")
    public ModelAndView getUserById(@RequestParam("id") int id) {
        User user = userService.getById(id);
        ModelAndView view = new ModelAndView();
        view.setViewName("userID");
        view.addObject("user", user);
        return view;
    }

    @PostMapping(value="/update")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/allUsers");
        userService.update(user);
        return view;
    }

    @PostMapping(value="/delete")
    public ModelAndView deleteUser(@RequestParam("id") int id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/allUsers");
        User user = userService.getById(id);
        userService.delete(user);
        return view;
    }




}
