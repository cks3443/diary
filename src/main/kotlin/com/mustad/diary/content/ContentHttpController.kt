package com.mustad.diary.content

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/content")
class ContentHttpController {

    @PostMapping
    fun postContent(): ResponseEntity<Content> {

        return ResponseEntity.ok(Content())
    }
}