package crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import crud.model.User;
import crud.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;


    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        return "index";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsersList(@RequestParam(value = "page", required = false, defaultValue = "0") int page, Model model) {
        List<User> allUsers = userService.getAllUsersList();
        PagedListHolder<User> usersPages = new PagedListHolder<User>(allUsers);
        usersPages.setPageSize(5);
        usersPages.setPage(page);
        model.addAttribute("usersList", usersPages);
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAction(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        return "redirect:/users";

    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";


    }

    @RequestMapping(value = "/remove/{id}")
    public String removerUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/edit={id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));

        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchByName(@RequestParam("name") String name,
                               @RequestParam(value = "page", required = false, defaultValue = "0") int page
            , Model model) {
        List<User> usersList = userService.searchUsersByName(name);
        PagedListHolder<User> usersPages = new PagedListHolder<User>(usersList);
        usersPages.setPageSize(5);
        usersPages.setPage(page);
        model.addAttribute("usersList", usersPages);
        return "users";
    }


}
