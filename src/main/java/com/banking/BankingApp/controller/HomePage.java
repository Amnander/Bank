package com.banking.BankingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomePage
{
    @GetMapping("/home-bank")
    public String homeBank(Model model)

    {
        model.addAttribute("message","Welcome to Home Bank !!");
        return "home-bank";
    }

    @PostMapping("add-account/")
    public String addAccount()

    {
        return "Iam not a real bank";
    }
}
