package com.mustad.diary.about

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/about")
class AboutHtmlController {

    val ABOUT_PAGE = "about"

    @GetMapping
    fun get_about_page() = ABOUT_PAGE
}