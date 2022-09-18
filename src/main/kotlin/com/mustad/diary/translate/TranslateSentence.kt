package com.mustad.diary.translate

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.Type
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "translatesentence")
class TranslateSentence : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "create_at", updatable = false)
    @CreationTimestamp
    open var createAt: Timestamp? = null

    @Column(name = "updated_at", updatable = true)
    @UpdateTimestamp
    open var updatedAt: Timestamp? = null

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "text", length = 5000)
    open var text: String? = null
}