package com.mustad.diary

import com.mustad.diary.translate.TranslateSentenceRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DiaryApplicationTests {

    @Autowired
    lateinit var tsentences: TranslateSentenceRepository

    @Test
    fun contextLoads() {
    }

    @Test
    fun `Can It get the counts normally`() {

        val counts = tsentences.count()

        assertThat(counts).isEqualTo(346L)
    }

}
