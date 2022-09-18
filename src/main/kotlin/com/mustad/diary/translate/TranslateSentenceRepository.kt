package com.mustad.diary.translate

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository

interface TranslateSentenceRepository : Repository<TranslateSentence, Long> {

    @Query("SELECT COUNT(ts.id) FROM TranslateSentence ts")
    fun count(): Long

    fun findById(id: Long): TranslateSentence?
}