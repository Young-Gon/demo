package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class MainController {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("eventName", "FIFA 2018")
        return "hello"
    }
}