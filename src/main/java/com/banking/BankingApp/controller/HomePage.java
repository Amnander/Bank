package com.banking.BankingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomePage
{
    @GetMapping("/home-bank")
    public String homeBank(Model model)

    {
        model.addAttribute("message","Welcome to Home Bank !!");
        return "home-bank";
    }

    @RequestMapping("about/")
    public String about()
    {
        return "Iam not a real bank";
    }
}
