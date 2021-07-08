package com.amemais.controller;

import com.amemais.interceptor.UserSession;
import com.amemais.model.Administrator;
import com.amemais.model.Client;
import com.amemais.repository.AdministratorRepository;
import com.amemais.repository.ClientRepository;
import com.amemais.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Logincontroller {

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ExamRepository examRepository;

    @Autowired
    UserSession userSession;

    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public String loginPagina() {
        return "/login/login";
    }

    @RequestMapping(value = "/login/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> model) {

        Administrator a = administratorRepository.findByUsername(username);
        Client c = clientRepository.findByUsername(username);
        if (a != null && a.getUsername().equals(username) && a.getPassword().equals(password)) {
            userSession.addLoggedAdmin(a);
            return "redirect:/administrator/list";
        } else if (c != null && c.getUsername().equals(username) && c.getPassword().equals(password)) {
            userSession.addLoggedClient(c);
            return "redirect:/client/listExamsClient";
        }
        model.put("message", "Login ou senha inválidos");
        return "/login/login";
    }

    @RequestMapping(value = "/login/logout", method = RequestMethod.GET)
    public String logout() {
        userSession.removeLoggedAdmin();
        userSession.removeLoggedClient();
        return "/login/login";
    }
}
