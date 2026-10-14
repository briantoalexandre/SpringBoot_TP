package org.ldv.myhello.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import org.springframework.ui.Model
import org.springframework.ui.set

@Controller
class MainController {
    @GetMapping("/")
    fun index(model: Model): String {
        model["titre"] = "exemple de vue"
        model["para"] = "lorem..."
        return "index"

    }

    @GetMapping("/hello")
    @ResponseBody
    fun hello(@RequestParam q : Map<String, String>): String {
        val nom = q["nom"] ?: ""
        val prenom = q["prenom"] ?: ""
        return "hello ${nom} ${prenom}!!!"
    }

    @GetMapping("/hello-{language}")
    @ResponseBody
    fun findL(@PathVariable("language") language: String,
              request: HttpServletRequest): String {
        return "langage ${language}"
    }




}