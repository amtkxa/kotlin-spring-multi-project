package com.amtkxa.domain.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id", nullable = false)
        var userId: Long = 0,
        @Column(name = "name", nullable = false)
        var name: String = "",
        @Column(name = "country", nullable = false)
        var country: String = "",
        @Column(name = "updated", nullable = false)
        var updated: LocalDateTime = LocalDateTime.now()
) : Serializable {

    fun merge(user: User) {
        name = user.name
        country = user.country
    }

    @PrePersist
    fun prePersist() {
        updated = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updated = LocalDateTime.now()
    }
}