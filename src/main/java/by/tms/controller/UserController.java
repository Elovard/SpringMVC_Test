package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private InMemoryUserStorage inMemoryUserStorage;

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView){
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView regPage(ModelAndView modelAndView, String name, String login, String password, HttpSession httpSession){
        modelAndView.setViewName("reg");
        modelAndView.addObject("name", name);
        modelAndView.addObject("login", login);
        modelAndView.addObject("password", password);
        User user = new User(name, login, password);
        inMemoryUserStorage.saveUser(user);
        httpSession.setAttribute("messageRegSuccess", "You've successfully registered!");
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView getAuthPage(ModelAndView modelAndView){
        modelAndView.setViewName("auth");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView authPage(ModelAndView modelAndView, String login, String password, HttpSession httpSession){
        modelAndView.setViewName("auth");
        User ByLogin = inMemoryUserStorage.getByLogin(login); // check
        if(ByLogin == null){
            httpSession.setAttribute("messageNotRegistered", "You are not registered here!");
            modelAndView.setViewName("redirect:/user/auth");
        } else if (!ByLogin.getPassword().equals(password)){
            httpSession.setAttribute("messageWrongPass", "Wrong password");
            modelAndView.setViewName("redirect:/user/auth");
        } else {
            httpSession.setAttribute("messageAuthSuccess", "Welcome, user!");
            httpSession.setAttribute("user", ByLogin);
        }

        return modelAndView;
    }

    @GetMapping(path = "/logout")
    public ModelAndView getLogoutPage(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping(path = "/logout")
    public ModelAndView logoutPage(ModelAndView modelAndView, HttpSession httpSession){
        modelAndView.setViewName("index");
        httpSession.invalidate();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
