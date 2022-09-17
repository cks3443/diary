package com.mustad.diary.diary

import com.google.gson.Gson
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/diary")
class DiaryHtmlController(
    private val gson: Gson,

    ) {

    val DIARY = "diary"

    @GetMapping
    fun getDiary(
    ): String {

        return DIARY
    }
}