package crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crud.model.User;
import crud.service.UserService;

@Controller
public class UserController {
    private UserService userService;


    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String getAllUsersList(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("getAllUsersList", userService.getAllUsersList());
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(User user) {
        if (user.getId() == 0) {
            userService.addUser(user);
        } else userService.updateuser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removerUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("getAllUsersList", userService.getAllUsersList());
        return "users";
    }

    @RequestMapping(value = "userdata/{id}")
    public String userData(@PathVariable("id") int id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "userdata";
    }
}
