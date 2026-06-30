package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import kotlin.random.Random

@Controller
class HelloController {
    @GetMapping("/")
    fun index(model: Model): String {
        val num = Random.nextInt(1, 10)
        model.addAttribute("message", "Hello World! num: $num")
        return "index"
    }
}