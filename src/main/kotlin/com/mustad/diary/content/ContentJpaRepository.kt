package com.mustad.diary.content

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentJpaRepository : JpaRepository<Content, Long> {
}