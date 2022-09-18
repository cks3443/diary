package com.mustad.diary.translate

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository

interface TranslateSenteceRepository : Repository<TranslateSentence, Long> {

    @Query("SELECT COUNT(ts.id) FROM TranslateSentence ts")
    fun count(): Long
}