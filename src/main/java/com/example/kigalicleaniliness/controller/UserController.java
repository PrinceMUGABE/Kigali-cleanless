package com.example.kigalicleaniliness.controller;

import com.example.kigalicleaniliness.model.UserModel;
import com.example.kigalicleaniliness.serviceImplementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImplementation userService;

@GetMapping("/users")
    public String showUserList(Model model){
    List<UserModel> listUsers = userService.listUsers();
    model.addAttribute("listUsers", listUsers);

    return "displayUsers-form";
    }

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);

        return "signupPage";
    }
    @PostMapping("/signup")
    public String signupForm(UserModel user, Model model, RedirectAttributes ra){

        try{
            UserModel savedUser = userService.saveUser(user);
            model.addAttribute("user", savedUser);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/login";
    }






    @GetMapping("/login")
    public String getLoginPage(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);

        return "loginPage";
    }
    @PostMapping("/login")
    public String login(UserModel user, Model model, RedirectAttributes ra){
        UserModel savedUser = userService.findUserByUsername(user);
        if (savedUser!=null){
            if (savedUser.getUsername()=="admin"){
                if (savedUser.getPassword().equals(user.getPassword())){
                    return "redirect:employee/list";
                }else {
                    ra.addFlashAttribute("message", "wrong password");
                    return "redirect:/login";
                }
            }
            else {
                if (savedUser.getUsername()==user.getUsername()){
                    if (savedUser.getPassword().equals(user.getPassword())){
                        return "index";
                    }else {
                        ra.addFlashAttribute("message", "wrong password");
                        return "redirect:/login";
                    }
                }else {
                    ra.addFlashAttribute("message", "invalid credential");
                    return "redirect:/login";
                }
            }
        }
        ra.addFlashAttribute("message", "Try again");

//        user.setArmy_number(0);
//        user.setPassword("");
        return "";
    }






    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model, RedirectAttributes ra){

        try {
            UserModel user = userService.findUserById(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "editUser (ID: " + id + " )");
            return "signupPage";
        }catch (Exception ex){
            ra.addFlashAttribute("message", "Error: Account not available");
        }

        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model, RedirectAttributes ra){
    try {
            userService.deleteUser(id);
            ra.addFlashAttribute("message", "Account deleted successfully");
            //return "redirect:/users";

    }catch (Exception ex){
        ra.addFlashAttribute("message", "Account not removed!");

    }
        return "redirect:/users";
    }
}
