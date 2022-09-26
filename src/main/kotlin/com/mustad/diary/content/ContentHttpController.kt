package com.mustad.diary.content

import com.google.gson.Gson
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/content")
class ContentHttpControlleri(
    private val jcontents: ContentJpaRepository,
    private val gson: Gson,
) {

    @PostMapping("/new")
    fun postContent(): ResponseEntity<Content> {

        return ResponseEntity.ok(Content())
    }

    @PostMapping("/{id}")
    @ResponseBody
    fun postContentById(
        @PathVariable id: Long,
        model: Model,
    ): ResponseEntity<Content?> {

        return try {
            val contentByid = jcontents.findById(id).get()

            if (contentByid.entered == null) contentByid.entered = 0

            if (contentByid.tried == null) contentByid.tried = 0

            contentByid.entered = contentByid.entered!! + 1

            jcontents.save(contentByid)

            ResponseEntity.ok().body(contentByid)

        } catch (e: Exception) {
            e.printStackTrace()

            ResponseEntity.badRequest().body(null)
        }
    }

    @PutMapping("/save")
    fun putContent(
        s_content: String
    ): ResponseEntity<Content?> {

        return try {
            val content = gson.fromJson(s_content, Content::class.java)

            jcontents.save(content)

            ResponseEntity.ok().body(content)

        } catch (e: Exception) {
            e.printStackTrace()

            ResponseEntity.badRequest().body(null)
        }

    }
}