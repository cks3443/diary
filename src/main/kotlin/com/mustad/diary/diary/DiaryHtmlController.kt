package com.mustad.diary.diary

import com.google.gson.Gson
import com.mustad.diary.content.Content
import com.mustad.diary.content.ContentRepository
import com.mustad.diary.translate.TranslateSentence
import com.mustad.diary.translate.TranslateSentenceRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.io.IOException
import java.util.*
import kotlin.random.Random

@Controller
@RequestMapping("/diary")
class DiaryHtmlController(
    private val gson: Gson,
    private val sentences: TranslateSentenceRepository,
    private val contents: ContentRepository,

    ) {

    val DIARY = "diary"

    @GetMapping
    fun getDiary(
    ): String {

        return DIARY
    }

    @PutMapping
    @ResponseBody
    fun postDiary(
        _content: String,
    ): ResponseEntity<Content?> {


        val content = gson.fromJson(_content, Content::class.java)

        return try {

            var gone = true

            var ts: TranslateSentence? = null

            val cnt = sentences.count()

            while (gone) {

                val randLong = Random.nextLong(1L, cnt)

                val next_st = sentences.findById(randLong)

                next_st?.let {
                    ts = it

                    gone = false
                }
            }

            content.translateSentence = ts

            val encodeString = Base64.getUrlEncoder().encodeToString(content.text!!.toByteArray())

            content.securityKey =
                if (encodeString.length < 15) {
                    encodeString
                } else {
                    encodeString.slice(0..14)
                }

            contents.save(content)

            val ent = ResponseEntity.ok(content)

            ent

        } catch (e: IOException) {
            e.printStackTrace()

            ResponseEntity.badRequest().body(null)
        }

    }

    @PostMapping("/new")
    @ResponseBody
    fun postNew() = ResponseEntity.ok(Content())
}