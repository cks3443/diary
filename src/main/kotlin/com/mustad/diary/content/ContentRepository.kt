package com.mustad.diary.content

import org.springframework.data.repository.Repository

interface ContentRepository : Repository<Content, Long> {

    fun save(content: Content)
}