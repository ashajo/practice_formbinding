package se.lexicon.practice_formbinding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CustomerController {

    @GetMapping("/customers")
    public String findAll(){
        return "customers";
    }
    @GetMapping("customer/create")
    public String getForm(){
        return "create-customer";
    }
    @PostMapping("customer/process")
    public String create(){
        return "create-customer";
    }


    @GetMapping("/customerDetails")
    public String find(){
        return "customerDetails";
    }


}
