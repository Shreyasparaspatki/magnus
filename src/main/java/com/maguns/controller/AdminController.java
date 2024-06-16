package com.maguns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;


import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maguns.pojo.AdminPojo;
import com.maguns.pojo.ContactPojo;
import com.maguns.serivce.AdminService;
import com.maguns.serivce.ContactSerivce;



@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ContactSerivce contactSerivce;

    @GetMapping("/crm")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginData(@RequestParam("username") String username, 
                            @RequestParam("password") String password, 
                            ModelMap modelMap, 
                            HttpSession httpSession) {
        AdminPojo adminPojo = adminService.findbyusernamepassword(username, password);
        if (adminPojo != null) {
            httpSession.setAttribute("pojo", adminPojo);
            httpSession.setMaxInactiveInterval(20);
            System.out.println(adminPojo);
            List<ContactPojo> list = contactSerivce.getAllContactPojos();
            modelMap.addAttribute("contacts", list);
            return "Viewproject";
        }
        modelMap.addAttribute("error", "Invalid username or password. Please try again.");
        return "login";
    }
}

