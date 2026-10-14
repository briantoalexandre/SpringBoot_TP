package org.ldv.myhello.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller

class MainController {
    @GetMapping("/")
    @ResponseBody
    fun index(): String {
        return "hello world !!!"
    }

    @GetMapping("/hello")
    @ResponseBody
    fun hello(@RequestParam q : Map<String, String>): String {
        val nom = q["nom"] ?: ""
        val prenom = q["prenom"] ?: ""
        return "hello ${nom} ${prenom}!!!"
    }

}