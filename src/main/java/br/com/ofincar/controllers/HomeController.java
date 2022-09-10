package br.com.ofincar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    ModelAndView getPage() {
        return new ModelAndView("index");
    }

    @GetMapping("/entrar")
    ModelAndView signin() {
        return new ModelAndView("signin");
    }

}
