package com.mustad.diary.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeHtmlController {

    val INDEX = "index"

    @GetMapping
    fun home(): String {

        return INDEX
    }
}