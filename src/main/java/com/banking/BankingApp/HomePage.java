package com.banking.BankingApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage
{
    @RequestMapping ("/")
    public String greet()
    {
        return "Welcome to Home Bank";
    }

    @RequestMapping("about/")
    public String about()
    {
        return "Iam not a real bank";
    }
}
