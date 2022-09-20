package com.mustad.diary.content

import com.mustad.diary.translate.TranslateSentence
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.Type
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.security.Key
import java.security.SecureRandom
import java.sql.Timestamp
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec
import javax.persistence.*


@Entity
@Table(name = "content")
open class Content : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null


    @Column(name = "create_at", updatable = false)
    @CreationTimestamp
    open var createAt: Timestamp? = null

    @Column(name = "updated_at", updatable = true)
    @UpdateTimestamp
    open var updatedAt: Timestamp? = null

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "text", length = 5000)
    open var text: String? = null

    @Column(name = "security_key")
    open var securityKey: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    open var translateSentence: TranslateSentence? = null


}